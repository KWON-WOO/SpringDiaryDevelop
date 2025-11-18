package com.springdiaryproject.springdiarydevelop.repository;

import com.springdiaryproject.springdiarydevelop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
