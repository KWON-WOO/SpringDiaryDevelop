package com.springdiaryproject.springdiarydevelop.dto.User;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReadUserResponse {
    private final Long id;
    private final String name;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ReadUserResponse(UserDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.createdAt = dto.getCreatedAt();
        this.modifiedAt = dto.getModifiedAt();
    }
}
