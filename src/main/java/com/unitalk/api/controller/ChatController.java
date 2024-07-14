package com.unitalk.api.controller;

import com.unitalk.api.model.Chat;
import com.unitalk.api.service.ChatService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private ChatService chatService;
    private static Long chatId = 0L;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Chat sendMessage(@Payload Chat chat) {
        chat.setId(++chatId);
        chat.setTimestamp(LocalDateTime.now());
        return chat;
    }
    //그냥 닉네임
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Chat addUser(@Payload Chat chat,
                        SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chat.getSender());
        chat.setId(++chatId);
        chat.setTimestamp(LocalDateTime.now());
        chat.setMessage(chat.getSender() + " joined the chat");
        return chat;
    }
    @GetMapping("/messages")
    public List<Chat> getMessages() {
        return chatService.getChats();
    }



    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/send-test-message")
    public ResponseEntity<String> sendTestMessage() {
        Chat chat = new Chat(null, "This is a test message from the backend", "Server", LocalDateTime.now());
        messagingTemplate.convertAndSend("/topic/public", chat);
        return ResponseEntity.ok("Test message sent");
    }
}


