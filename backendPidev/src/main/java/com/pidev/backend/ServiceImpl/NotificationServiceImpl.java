package com.pidev.backend.serviceImpl;

import com.pidev.backend.entity.Notification;
import com.pidev.backend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service

public class NotificationServiceImpl implements NotificationService {
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public NotificationServiceImpl(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void sendNotification(String userId, Notification notification) {
        // Envoie la notification à l'utilisateur spécifié via WebSocket
        messagingTemplate.convertAndSendToUser(userId, "/queue/notifications", notification);
    }
}
