package com.unitalk.online.service;

import com.unitalk.online.model.ChatbotResponse;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {
    public ChatbotResponse processMessage(String message) {
        String response;
        if (message.contains("패널티")) {
            response = "2회 이상 80%미만 수강시 더이상 서비스불가의 패널티가 부여됩니다.";
        } else if (message.contains("상담신청")) {
            response = "상담신청은 학생포털에서 가능합니다.";
        } else {
            response = "죄송합니다. 이해하지 못했습니다.";
        }
        return new ChatbotResponse(response);
    }
}