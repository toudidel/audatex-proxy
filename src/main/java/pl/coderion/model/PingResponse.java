package pl.coderion.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class PingResponse {

    @Getter @Setter private String hostName;

    @Getter @Setter private Integer returnCode;

    @Getter @Setter private Date timestamp;

    @Getter @Setter private List<PingResponseMessage> messages;
}
