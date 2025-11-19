package com.springdiaryproject.springdiarydevelop.dto.comment;

import lombok.Getter;

@Getter
public class UpdateCommentRequest {
    private Long commentId;
    private String comment;
}
