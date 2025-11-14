package com.springdiaryproject.springdiarydevelop.entity;

import com.springdiaryproject.springdiarydevelop.dto.User.CreateUserRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Setter
    @Column(nullable = false)
    private String email;

    public User(CreateUserRequest request) {
        this.name = request.getName();
        this.email = request.getEmail();
        this.password = request.getPassword();
    }
}
