package io.github.bacellar08.magalu.msmagalu.controller;

import io.github.bacellar08.magalu.msmagalu.domain.Notification;
import io.github.bacellar08.magalu.msmagalu.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {


    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {

        if (notification != null) {
            var newNotification = notificationService.createNotification(notification);
            return ResponseEntity.ok(newNotification);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getNotifications() {
        var notifications = notificationService.getAllNotifications();

        return ResponseEntity.ok(notifications);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }


}
