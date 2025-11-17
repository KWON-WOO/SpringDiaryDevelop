package com.springdiaryproject.springdiarydevelop.dto.User;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String name;
    private String email;
    private String password;

    public void setPassword(String password) {
        this. password= password;
    }
}
