package com.unitalk.online.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long senderUserId;
    private Long recipientUserId;
    private String message;
    private LocalDateTime timestamp;
    private boolean isRead;

    public Notification(Long senderUserId, Long recipientUserId, String message) {
        this.senderUserId = senderUserId;
        this.recipientUserId = recipientUserId;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.isRead = false;
    }
}


