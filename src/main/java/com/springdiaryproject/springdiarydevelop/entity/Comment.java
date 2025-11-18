package com.springdiaryproject.springdiarydevelop.entity;

import com.springdiaryproject.springdiarydevelop.dto.comment.CreateCommentRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="comments")
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="schedule_id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String comment;

    public Comment(Schedule schedule, User user, CreateCommentRequest request) {
        this.schedule = schedule;
        this.user = user;
        this.comment = request.getComment();
    }

    public static Comment of(Schedule schedule, User user, CreateCommentRequest request) {
        return new Comment(schedule, user, request);
    }
}
