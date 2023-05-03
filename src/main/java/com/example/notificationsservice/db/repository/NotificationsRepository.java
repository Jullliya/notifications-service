package com.example.notificationsservice.db.repository;

import com.example.notificationsservice.db.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
}