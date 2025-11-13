package com.springdiaryproject.springdiarydevelop.entity;

import com.springdiaryproject.springdiarydevelop.dto.User.CreateUserRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="users")
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false)
    private String name;
    private String email;

    public User(CreateUserRequest request) {
        this.name = request.getName();
        this.email = request.getEmail();
    }
}
