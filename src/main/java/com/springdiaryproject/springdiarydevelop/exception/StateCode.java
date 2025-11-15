package com.springdiaryproject.springdiarydevelop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StateCode {
    /***** 2xx code *****/
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accept"),
    NO_CONTENT(204, "No Content"),

    /***** 4xx code *****/
    BAD_REQUEST(400, "잘못된 요청값"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden");

    private final int status;
    private final String message;
}
