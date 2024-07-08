package io.github.bacellar08.magalu.msmagalu.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

    PENDING,
    SUCCESS,
    ERROR,
    CANCELED;

    @JsonCreator
    public static Status fromString(String value) {
        for (Status status : Status.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown enum type " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }


}
