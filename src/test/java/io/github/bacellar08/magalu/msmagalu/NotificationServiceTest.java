package io.github.bacellar08.magalu.msmagalu;


import io.github.bacellar08.magalu.msmagalu.domain.Notification;
import io.github.bacellar08.magalu.msmagalu.domain.Status;
import io.github.bacellar08.magalu.msmagalu.repository.NotificationRepository;
import io.github.bacellar08.magalu.msmagalu.service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NotificationServiceTest {

    @Mock
    private NotificationRepository notificationRepository;


    @InjectMocks
    private NotificationService notificationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ifConsumesStatusErrorAndCancel() {

        Notification notification = new Notification();
        notification.setStatus(Status.ERROR);
        notificationService.consumeNotification(notification);

        assertEquals(Status.CANCELED, notification.getStatus());

    }

    @Test
    public void ifConsumesStatusPendingAndSuccess() {
        Notification notification = new Notification();
        notification.setStatus(Status.PENDING);
        notificationService.consumeNotification(notification);

        assertEquals(Status.SUCCESS, notification.getStatus());
    }

    @Test
    public void ifIsCheckingAndSendingNotification() {
        LocalDateTime now = LocalDateTime.now();
        Notification notification = new Notification();
        notification.setStatus(Status.PENDING);
        notification.setDateTime(now.minusMinutes(1));

        when(notificationRepository.findByStatusInAndDateTimeBefore(any(), any())).thenReturn(List.of(notification));

        notificationService.checkAndSend(now);

        verify(notificationRepository).findByStatusInAndDateTimeBefore(any(), any());
        verify(notificationRepository).saveAll(any());

        assertEquals(Status.SUCCESS, notification.getStatus());
    }
}
