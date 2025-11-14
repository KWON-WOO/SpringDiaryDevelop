package com.springdiaryproject.springdiarydevelop.exception;

import org.springframework.http.HttpStatus;

public enum StateCode {
        /***** 2xx code *****/
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accept"),
    NO_CONTENT(204,"No Content"),

        /***** 400 code *****/
    UNAUTHORIZED(401,"Unauthorized"),
    FORBIDDEN(403, "Forbidden");

    private final int status;
    private final String message;


    StateCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
