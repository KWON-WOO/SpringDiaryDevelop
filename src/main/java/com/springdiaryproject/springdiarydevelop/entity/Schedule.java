package com.springdiaryproject.springdiarydevelop.entity;

import com.springdiaryproject.springdiarydevelop.dto.CreateScheduleRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String name;
    @Column(nullable =false)
    private String title;
    @Column(nullable=false)
    private String content;

    public Schedule(CreateScheduleRequest request) {
        this.name = request.getName();
        this.title = request.getTitle();
        this.content = request.getContent();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
