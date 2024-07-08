package io.github.bacellar08.magalu.msmagalu.domain;

public enum Channel {

    WHATSAPP(1L, "whatsapp"),
    EMAIL(2L, "email"),
    SMS(3L, "sms"),
    PUSH(4L, "push");

    private Long id;
    private String description;

    Channel(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
