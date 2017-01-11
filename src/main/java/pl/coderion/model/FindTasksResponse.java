package pl.coderion.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class FindTasksResponse extends BaseResponse {

    @Getter @Setter private FindTasksResponsePayload payload;
}
