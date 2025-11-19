package com.springdiaryproject.springdiarydevelop.dto.schedule;

import com.springdiaryproject.springdiarydevelop.entity.Schedule;
import com.springdiaryproject.springdiarydevelop.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleDto {
    private final Long id;
    private final User user;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    public ScheduleDto(Schedule schedule) {
        this.id = schedule.getId();
        this.user = schedule.getUser();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }

    public static ScheduleDto of(Schedule schedule) {
        return new ScheduleDto(schedule);
    }
}
