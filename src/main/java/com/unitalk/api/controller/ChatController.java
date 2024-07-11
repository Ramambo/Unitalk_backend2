package com.unitalk.api.controller;

import com.unitalk.api.model.Chat;
import com.unitalk.api.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    public ResponseEntity<List<Chat>> getChats() {
        return ResponseEntity.ok(chatService.getChats());
    }

    @PostMapping
    public ResponseEntity<Chat> sendMessage(@RequestBody Chat chat) {
        return ResponseEntity.ok(chatService.sendMessage(chat.getMessage(), chat.getSender()));
    }
}