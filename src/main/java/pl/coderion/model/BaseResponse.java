package pl.coderion.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class BaseResponse {

    @Getter @Setter private String hostName;

    @Getter @Setter private Integer returnCode;

    @Getter @Setter private Date timestamp;

    @Getter @Setter private List<BaseResponseMessage> messages;

    public BaseResponse() {
        this.messages = new ArrayList<>();
    }
}
