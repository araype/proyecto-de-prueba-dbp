package com.example.biquerito.reaction.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.biquerito.publication.domain.Publication;
import com.example.biquerito.reaction.domain.Reaction;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

import com.example.biquerito.reaction.domain.ReactionRepository;
import com.example.biquerito.user.domain.User;
import com.example.biquerito.user.domain.UserRepository;
import com.example.biquerito.publication.domain.PublicationRepository;

@RestController
@RequestMapping("/reaction")
public class ReactionController {

    @Autowired
    private ReactionRepository reactionRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PublicationRepository publicationRepository;

    @GetMapping
    public ResponseEntity<List<Reaction>> getAllReactions() {
        List<Reaction> reactions = reactionRepository.findAll();
        return new ResponseEntity<>(reactions, HttpStatus.OK);
    }

    @GetMapping("/publication/{publicationId}")
    public ResponseEntity<List<Reaction>> getReactionsByPublicationId(@PathVariable Long publicationId) {
        List<Reaction> reactions = reactionRepository.findByPublicationId(publicationId);
        return new ResponseEntity<>(reactions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reaction> createReaction(@RequestBody Reaction reaction) {
        // Busca el usuario en la base de datos con el userId proporcionado
        Optional<User> userOptional = userRepository.findById(reaction.getUserIdTransient());
        Optional<Publication> publicationOptional = publicationRepository.findById(reaction.getUserIdTransient());

        // Si no existe el usuario o la publicación, devuelve un error

        if (!userOptional.isPresent() || !publicationOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Manejar el error
        }

        reaction.setUser(userOptional.get()); // Establece el objeto User en la reacción
        reaction.setPublication(publicationOptional.get());
        Reaction newReaction = reactionRepository.save(reaction); // Guarda la reacción

        return new ResponseEntity<>(newReaction, HttpStatus.CREATED);
    }

}
