package com.example.notificationsservice.db.service;

import com.example.notificationsservice.db.entity.Notifications;

import java.time.LocalDate;
import java.time.LocalTime;

public interface NotificationsService {
    Notifications createNotification(Long userId, String name, LocalDate date, LocalTime time, Long repAmount, Long repPeriod);

    Notifications updateNotification(Long notId, Long userId, String name, LocalDate date, LocalTime time, Long repAmount, Long repPeriod);

    Notifications getNotById(Long id);

    void deleteNotById(Long id);
}
