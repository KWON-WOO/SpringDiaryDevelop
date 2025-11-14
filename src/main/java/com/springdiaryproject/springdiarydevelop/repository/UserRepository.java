package com.springdiaryproject.springdiarydevelop.repository;

import com.springdiaryproject.springdiarydevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    Boolean existsByEmail(String email);
    Optional<User> findByEmailAndPassword(String name, String password);
}
