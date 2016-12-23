package pl.coderion.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class PingResponseMessage {

    @Getter @Setter private String messageCode;

    @Getter @Setter private Integer severity;

    @Getter @Setter private String text;
}
