package com.springdiaryproject.springdiarydevelop.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {
    private final Long id;
    private final String name;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateScheduleResponse(ScheduleDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.createdAt = dto.getCreatedAt();
        this.modifiedAt = dto.getModifiedAt();
    }
}
