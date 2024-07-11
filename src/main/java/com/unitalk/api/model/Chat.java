package com.unitalk.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    private Long id;
    private String message;
    private String sender;
    private LocalDateTime timestamp;
}