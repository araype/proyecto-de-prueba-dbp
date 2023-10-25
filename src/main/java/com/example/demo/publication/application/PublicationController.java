package com.example.demo.publication.application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.publication.domain.Publication;
import com.example.demo.publication.domain.PublicationRepository;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Publication>> getAllPublications() {
        List<Publication> publications = publicationRepository.findAll();
        return new ResponseEntity<>(publications, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Publication> createPublication(@RequestBody Publication publication) {
        // Busca el usuario en la base de datos con el userId proporcionado
        Optional<User> userOptional = userRepository.findById(publication.getUserIdTransient());

        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Manejar el error
        }

        publication.setUser(userOptional.get()); // Establece el objeto User en la publicación
        Publication newPublication = publicationRepository.save(publication); // Guarda la publicación

        return new ResponseEntity<>(newPublication, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Publication>> getPublicationsByUserId(@PathVariable Long userId) {
        List<Publication> publications = publicationRepository.findByUserId(userId);
        return new ResponseEntity<>(publications, HttpStatus.OK);
    }

}