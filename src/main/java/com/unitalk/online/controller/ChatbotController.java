package com.unitalk.online.controller;

import com.unitalk.online.model.ChatbotResponse;
import com.unitalk.online.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {
    @Autowired
    private ChatbotService chatbotService;

    @PostMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        return ResponseEntity.ok(chatbotService.processMessage(message).toString());
    }
/*
    @GetMapping("/api/wow")
    public ResponseEntity<String> handleRequest() {

        String message = "Success"; // 성공 메시지
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }*/
@GetMapping("api/wow")
public String handleWowRequest() {
    // 요청 처리 로직을 추가할 수도 있고, 단순히 로그만 출력할 수도 있습니다.
    System.out.println("Received request on /api/wow");
    return "Wow, such request!";
}


}


