package io.github.bacellar08.magalu.msmagalu.repository;

import io.github.bacellar08.magalu.msmagalu.domain.Notification;
import io.github.bacellar08.magalu.msmagalu.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findAllByStatus(Status status);

    List<Notification> findByStatusInAndDateTimeBefore(List<Status> statusList, LocalDateTime dateTime);
}
