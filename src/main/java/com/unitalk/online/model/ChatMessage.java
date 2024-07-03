package com.unitalk.online.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;

@Table(name = "TEST")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    @jakarta.persistence.Id
    @Id
    private Long id;
    private String message;
    @Transient
    private String roomId;
    private Long senderId;
    private Long recipientId;
    private String content;
    private LocalDateTime timestamp;
    @Transient
    private Long user_no;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRoomId(String roomId) {
    }
}
