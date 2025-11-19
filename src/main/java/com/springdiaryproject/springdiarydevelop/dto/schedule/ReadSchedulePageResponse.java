package com.springdiaryproject.springdiarydevelop.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReadSchedulePageResponse {
    private String title;
    private String content;
    private Long commentCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String userName;
}
