package com.springdiaryproject.springdiarydevelop.dto.User;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReadUserResponse {
    private Integer id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    public ReadUserResponse(UserDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.createdAt = dto.getCreatedAt();
        this.modifiedAt = dto.getModifiedAt();
    }
}
