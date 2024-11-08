package com.pidev.backend.service;

import com.pidev.backend.entity.Notification;

public interface NotificationService {
    void sendNotification(String userId, Notification notification);

}
