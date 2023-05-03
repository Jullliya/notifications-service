package com.example.notificationsservice.db.entity;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "Notifications")
public class Notifications {

    @Id
    //пока оставляю так, дальше будет получать id встречи
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "User_Id")
    private Long userId;

    @Column(name = "Not_name", length = 64)
    private String notName;

    @Column(name = "Not_date")
    private LocalDate notDate;

    @Column(name = "Not_time")
    private LocalTime notTime;

    @Column(name = "rep_amount")
    private Long repAmount;

    @Column(name = "Rep_period")
    private Long repPeriod;

}