package com.unitalk.api.service;

import com.unitalk.api.model.Notification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    public List<Notification> getNotifications() {
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification(1L, "새로운 메시지가 있습니다.", false));
        notifications.add(new Notification(2L, "친구 요청이 왔습니다.", true));
        return notifications;
    }
}