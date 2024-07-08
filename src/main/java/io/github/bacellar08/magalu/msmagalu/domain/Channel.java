package io.github.bacellar08.magalu.msmagalu.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Channel {

    WHATSAPP,
    EMAIL,
    SMS,
    PUSH;

    @JsonCreator
    public static Channel fromString(String value) {
        for (Channel channel : Channel.values()) {
            if (channel.name().equalsIgnoreCase(value)) {
                return channel;
            }
        }
        throw new IllegalArgumentException("Canal Inválido " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }


}
