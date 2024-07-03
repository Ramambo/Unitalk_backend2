package com.unitalk.online.controller;

import com.unitalk.online.model.Notification;
import com.unitalk.online.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @MessageMapping("/notification")
    @SendTo("/topic/notifications")
    public Notification sendNotification(Notification notification, Principal principal) {
        Long senderId = Long.parseLong(principal.getName());
        notification.setSenderUserId(senderId);
        return notificationService.saveAndSend(notification);
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getUserNotifications(Principal principal) {
        Long userId = Long.parseLong(principal.getName());
        return ResponseEntity.ok(notificationService.getNotificationsForUser(userId));
    }

    @PutMapping("/{notificationId}/read")
    public ResponseEntity<Void> markNotificationAsRead(@PathVariable Long notificationId) {
        notificationService.markAsRead(notificationId);
        return ResponseEntity.ok().build();
    }
}