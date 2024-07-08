package io.github.bacellar08.magalu.msmagalu.scheduler;

import io.github.bacellar08.magalu.msmagalu.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class MagaluTaskScheduler {

    private final Logger logger = LoggerFactory.getLogger(MagaluTaskScheduler.class);

    private final NotificationService notificationService;

    public MagaluTaskScheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void runTasks() {

        var dateTime = LocalDateTime.now();

        logger.info("Running tasks at {} ", dateTime);

        notificationService.checkAndSend(dateTime);
    }
}
