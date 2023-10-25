package com.example.demo.session.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.session.domain.SessionRepository;
import com.example.demo.session.domain.Session;
import com.example.demo.user.domain.UserDTO;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private org.modelmapper.ModelMapper modelMapper; // Para convertir de un DTO a un objeto y viceversa

    @GetMapping("/session")
    public ResponseEntity<List<Session>> getAllSessions() {
        List<Session> sessions = sessionRepository.findAll();
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserDTO userDTO) {
        // user que tiene email y contraseña
        User user = modelMapper.map(userDTO, User.class); // convertimos el DTO en un User

        User userFromDB = userRepository.findByEmail(user.getEmail()); // Buscamos al usuario por su email en la bd
        if (userFromDB == null) { // Si no existe el usuario, devolvemos un error
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        UserDTO userFromDBDTO = modelMapper.map(userFromDB, UserDTO.class); // Convertimos el User en DTO
        if (!userFromDBDTO.getPassword().equals(userDTO.getPassword())) { // Si la contraseña no coincide, devolvemos un
            // error
            return new ResponseEntity<>("Wrong password", HttpStatus.UNAUTHORIZED);
        }
        // Si el usuario existe y la contraseña coincide, creamos una sesión para el
        // usuario
        Session session = new Session();
        session.setEmail(user.getEmail());
        session.setLoggedIn(true);
        sessionRepository.save(session); // Guardamos la sesión en la base de datos
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody UserDTO userDTO) {
        String email = userDTO.getEmail(); // Obtenemos el email del DTO

        // Validación de email
        if (email == null || email.isEmpty()) {
            return new ResponseEntity<>("Email is required", HttpStatus.BAD_REQUEST);
        }

        // Buscamos la sesión por el email del usuario en la base de datos
        Session session = sessionRepository.findByEmail(email);

        if (session == null) {
            // Si no existe la sesión, devolvemos un error
            return new ResponseEntity<>("Session not found", HttpStatus.NOT_FOUND);
        }

        // Borramos la sesión de la base de datos
        sessionRepository.delete(session);

        return new ResponseEntity<>("Logout successful", HttpStatus.OK);
    }

}
