package io.github.bacellar08.magalu.msmagalu.domain;

public enum Status {

    PENDING(1L, "pending"),
    SUCCESS(2L, "success"),
    CANCELED(3L, "canceled");

    private Long id;
    private String description;

    private Status(Long id, String description) {
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
