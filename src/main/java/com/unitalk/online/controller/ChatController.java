package com.unitalk.online.controller;

import com.unitalk.online.model.ChatMessage;
import com.unitalk.online.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import java.security.Principal;
import java.util.List;

@Controller
public class ChatController {
    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/chat/{roomId}")
    public ChatMessage sendMessage(@DestinationVariable String roomId, ChatMessage chatMessage, Principal principal) {
        Long senderId = Long.parseLong(principal.getName());
        chatMessage.setSenderId(senderId);
        chatMessage.setRoomId(roomId);
        return chatService.saveAndSend(chatMessage);
    }

    @GetMapping("/api/chat/history/{roomId}")
    public ResponseEntity<List<ChatMessage>> getChatHistory(@PathVariable String roomId) {
        return ResponseEntity.ok(chatService.getChatHistory(roomId));
    }
}