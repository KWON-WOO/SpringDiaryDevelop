package com.springdiaryproject.springdiarydevelop.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    protected StateCode code;
    public CustomException(StateCode code) {
        super(code.getMessage());
        this.code = code;
    }
    public CustomException(StateCode code, String message){
        super(message);
        this.code = code;
    }
}
