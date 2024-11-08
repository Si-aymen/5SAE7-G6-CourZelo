package com.pidev.backend.Repository;

import com.pidev.backend.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationRepository extends JpaRepository<Notification, String> {
}
