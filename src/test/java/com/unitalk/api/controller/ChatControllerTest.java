package com.unitalk.api.controller;

import com.unitalk.api.service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ChatController.class)
public class ChatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChatService chatService;

    @Test
    public void testGetChats() throws Exception {
        mockMvc.perform(get("/api/chats"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testSendMessage() throws Exception {
        String chatJson = "{\"message\":\"Test message\",\"sender\":\"user1\"}";

        mockMvc.perform(post("/api/chats")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(chatJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Test message"))
                .andExpect(jsonPath("$.sender").value("user1"));
    }
}