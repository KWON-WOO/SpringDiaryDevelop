package com.springdiaryproject.springdiarydevelop.exception;

public class ExceptionResponse {
    private int code;
    private String message;

    public ExceptionResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
