package com.example.notificationsservice.db.service.impl;

import com.example.notificationsservice.db.entity.Notifications;
import com.example.notificationsservice.db.repository.NotificationsRepository;
import com.example.notificationsservice.db.service.NotificationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class NotificationsServiceImpl implements NotificationsService {

    final NotificationsRepository notificationsRepository;

    @Override
    public Notifications createNotification(Long userId, String name, LocalDate date, LocalTime time, Long repAmount, Long repPeriod) {
        Notifications not = new Notifications();
        not = setData(not, userId, name, date, time, repAmount, repPeriod);
        return notificationsRepository.save(not);
    }

    @Override
    public Notifications updateNotification(Long notId, Long userId, String name, LocalDate date, LocalTime time, Long repAmount, Long repPeriod) {
        Notifications not = notificationsRepository.findById(notId).orElseThrow();
        not = setData(not, userId, name, date, time, repAmount, repPeriod);
        return notificationsRepository.save(not);
    }

    @Override
    public Notifications getNotById(Long id) {
        return notificationsRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteNotById(Long id) {
        if (notificationsRepository.existsById(id)) {
            notificationsRepository.deleteById(id);
        }
    }

    private Notifications setData(Notifications not, Long userId, String name, LocalDate date, LocalTime time, Long repAmount, Long repPeriod){
        not.setUserId(userId);
        not.setNotName(name);
        not.setNotDate(date);
        not.setNotTime(time);
        not.setRepAmount(repAmount);
        not.setRepPeriod(repPeriod);
        return not;
    }
}
