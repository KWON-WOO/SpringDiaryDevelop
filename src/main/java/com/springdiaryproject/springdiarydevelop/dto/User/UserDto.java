package com.springdiaryproject.springdiarydevelop.dto.User;

import com.springdiaryproject.springdiarydevelop.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
    }
}
