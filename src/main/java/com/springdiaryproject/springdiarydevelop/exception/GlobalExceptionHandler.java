package com.springdiaryproject.springdiarydevelop.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class GlobalExceptionHandler{

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponseDto> unAuthorizedException(CustomException e) {
        StateCode code = e.getCode();
        ExceptionResponseDto response = new ExceptionResponseDto(code.getStatus(), e.getMessage());
        return ResponseEntity.status(code.getStatus()).body(response);
    }
}
