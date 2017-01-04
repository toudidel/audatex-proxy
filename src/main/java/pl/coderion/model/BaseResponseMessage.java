package pl.coderion.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class BaseResponseMessage {

    @Getter @Setter private String messageCode;

    @Getter @Setter private Integer severity;

    @Getter @Setter private String text;

    @Getter @Setter private String localizedText;

    @Getter @Setter private List<String> additionalInfo;
}
