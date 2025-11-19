package com.springdiaryproject.springdiarydevelop.dto.comment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateCommentResponse {
    private final Long id;
    private final String scheduleTitle;
    private final String userName;
    private final String comment;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public UpdateCommentResponse(CommentDto dto) {
        this.id = dto.getId();
        this.scheduleTitle = dto.getSchedule().getTitle();
        this.userName = dto.getUser().getName();
        this.comment = dto.getComment();
        this.createdAt = dto.getCreatedAt();
        this.modifiedAt = dto.getModifiedAt();
    }

}
