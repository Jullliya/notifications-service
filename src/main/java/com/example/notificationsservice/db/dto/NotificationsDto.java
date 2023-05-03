package com.example.notificationsservice.db.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class NotificationsDto {

    private final Long id;
    private final Long userId;
    private final String notName;
    private final LocalDate notDate;
    private final LocalTime notTime;
    private final Long repAmount;
    private final Long repPeriod;
}
