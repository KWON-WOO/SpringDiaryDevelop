package com.springdiaryproject.springdiarydevelop.dto.login;

import lombok.Getter;

@Getter
public class LoginSessionInfo {
    private Long id;
    private String name;
    private String email;

    public LoginSessionInfo(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
