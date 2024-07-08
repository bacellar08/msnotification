package io.github.bacellar08.magalu.msmagalu.service;

import io.github.bacellar08.magalu.msmagalu.domain.Notification;
import io.github.bacellar08.magalu.msmagalu.domain.Status;
import io.github.bacellar08.magalu.msmagalu.repository.NotificationRepository;

import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;


@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public void deleteNotification(Long notificationId) {

        var notification = notificationRepository.findById(notificationId);

        if (notification.isPresent()) {
            var newNotification = notification.get();
            newNotification.setStatus(Status.CANCELED);
            notificationRepository.save(newNotification);
        }

    }

    public List<Notification> getNotificationsByStatus(Status status) {
        return notificationRepository.findAllByStatus(status);
    }


    public void checkAndSend(LocalDateTime dateTime) {
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(List.of(Status.ERROR, Status.PENDING), dateTime);


        for (Notification notification : notifications) {
            consumeNotification(notification);
        }

        notificationRepository.saveAll(notifications);
    }

    private void consumeNotification(Notification notification) {

        if (notification.getStatus() == Status.ERROR) {
            notification.setStatus(Status.CANCELED);
        }
        else if (notification.getStatus() == Status.PENDING) {
            //todo enviar notificações
            notification.setStatus(Status.SUCCESS);
        }
    }
}
