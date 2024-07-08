package io.github.bacellar08.magalu.msmagalu.repository;

import io.github.bacellar08.magalu.msmagalu.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
