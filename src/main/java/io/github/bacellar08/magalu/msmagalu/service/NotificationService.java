package io.github.bacellar08.magalu.msmagalu.service;

import io.github.bacellar08.magalu.msmagalu.domain.Notification;
import io.github.bacellar08.magalu.msmagalu.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
}
