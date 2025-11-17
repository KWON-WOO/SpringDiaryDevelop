package com.springdiaryproject.springdiarydevelop.dto.login;

import lombok.Getter;

@Getter
public class LoginInfo {
    private Long id;
    private String name;
    private String email;

    public LoginInfo(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
