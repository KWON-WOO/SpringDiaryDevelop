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
    UNAUTHORIZED(401, "인증에 실패하였습니다."),
    FORBIDDEN(403, "접근이 금지되었습니다.");

    private final int status;
    private final String message;
}
