package com.springdiaryproject.springdiarydevelop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionResponseDto {
    private int code;
    private String message;

    public static ExceptionResponseDto res(final CustomException custom) {
        int code = custom.getCode().getStatus();
        String message = custom.getCode().getMessage();
        return new ExceptionResponseDto(code, message);
    }
}
