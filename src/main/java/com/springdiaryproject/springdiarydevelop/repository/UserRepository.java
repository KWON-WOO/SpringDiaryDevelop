package com.springdiaryproject.springdiarydevelop.repository;

import com.springdiaryproject.springdiarydevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
