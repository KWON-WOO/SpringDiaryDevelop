package com.springdiaryproject.springdiarydevelop.entity;

import com.springdiaryproject.springdiarydevelop.dto.schedule.CreateScheduleRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable =false)
    private String title;

    @Column(nullable=false)
    private String content;

    public Schedule(User user, CreateScheduleRequest request) {
        this.user = user;
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
