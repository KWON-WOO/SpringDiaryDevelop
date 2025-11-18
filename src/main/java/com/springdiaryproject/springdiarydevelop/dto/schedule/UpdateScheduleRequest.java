package com.springdiaryproject.springdiarydevelop.dto.schedule;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {
    private Long userId;
    private String title;
    private String content;
}
