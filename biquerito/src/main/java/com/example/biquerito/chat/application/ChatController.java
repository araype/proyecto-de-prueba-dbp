package com.example.biquerito.chat.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// import java.util.Optional;

import com.example.biquerito.chat.domain.ChatRepository;
import com.example.biquerito.chat.domain.Chat;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatRepository chatRepository;

    @GetMapping()
    public ResponseEntity<List<Chat>> getAllChats() {
        List<Chat> chats = chatRepository.findAll();
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

}
