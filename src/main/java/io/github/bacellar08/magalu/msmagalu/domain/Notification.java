package io.github.bacellar08.magalu.msmagalu.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate dateTime;

    private String message;

    private Status status;

    private Channel channel;




}
