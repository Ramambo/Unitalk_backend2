package com.unitalk.api.service;

import com.unitalk.api.model.Chat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    public List<Chat> getChats() {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat(1L, "안녕하세요!", "user1", LocalDateTime.now()));
        chats.add(new Chat(2L, "반갑습니다!", "user2", LocalDateTime.now()));
        chats.add(new Chat(32423L, "fake!", "user4232", LocalDateTime.now()));
        return chats;
    }

    public Chat sendMessage(String message, String sender) {
        return new Chat(3L, message, sender, LocalDateTime.now());
    }
}