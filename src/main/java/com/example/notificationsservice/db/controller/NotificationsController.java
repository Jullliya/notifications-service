package com.example.notificationsservice.db.controller;

import com.example.notificationsservice.db.dto.NotificationsDto;
import com.example.notificationsservice.db.entity.Notifications;
import com.example.notificationsservice.db.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {

    private NotificationsService notificationsService;

    @Autowired
    public NotificationsController(NotificationsService notificationsService){
        this.notificationsService = notificationsService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Notifications> createNotification(@RequestBody NotificationsDto notificationsDto) {
        Notifications notifications = notificationsService.createNotification(notificationsDto.getUserId(), notificationsDto.getNotName(), notificationsDto.getNotDate(), notificationsDto.getNotTime(), notificationsDto.getRepAmount(), notificationsDto.getRepPeriod());
        return ResponseEntity.ok(notifications);
    };

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Notifications> updateNotification(@RequestBody NotificationsDto notificationsDto) {
        Notifications notifications = notificationsService.updateNotification(notificationsDto.getId(), notificationsDto.getUserId(), notificationsDto.getNotName(), notificationsDto.getNotDate(), notificationsDto.getNotTime(), notificationsDto.getRepAmount(), notificationsDto.getRepPeriod());
        return ResponseEntity.ok(notifications);
    };

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Notifications> getNotById(@PathVariable("id") Long id) {
        Notifications notifications = notificationsService.getNotById(id);
        return ResponseEntity.ok(notifications);
    };

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteNotification(@PathVariable("id") Long id) {
        notificationsService.deleteNotById(id);
    };

}
