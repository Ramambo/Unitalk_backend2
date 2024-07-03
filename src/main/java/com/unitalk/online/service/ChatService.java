package com.unitalk.online.service;

import com.unitalk.online.model.ChatMessage;
import com.unitalk.online.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {
    @Autowired

    private ChatRepository chatRepository;

    public ChatMessage saveAndSend(ChatMessage chatMessage) {
        chatMessage.setTimestamp(LocalDateTime.now());
        return chatRepository.save(chatMessage);
    }

    public List<ChatMessage> getChatHistory(String roomId) {
        return chatRepository.findByRoomIdOrderByTimestampAsc(roomId);
    }
}
