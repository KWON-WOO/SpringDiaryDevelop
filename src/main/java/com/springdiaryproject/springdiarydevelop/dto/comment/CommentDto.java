package com.springdiaryproject.springdiarydevelop.dto.comment;

import com.springdiaryproject.springdiarydevelop.entity.Comment;
import com.springdiaryproject.springdiarydevelop.entity.Schedule;
import com.springdiaryproject.springdiarydevelop.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private Schedule schedule;
    private User user;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    CommentDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }

    public static CommentDto of (Comment comment) {
        return new CommentDto(comment);
    }
}
