package io.github.bacellar08.magalu.msmagalu.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime dateTime;

    private String message;

    private String destination;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    @Enumerated(EnumType.STRING)
    private Channel channel;

    public Notification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
