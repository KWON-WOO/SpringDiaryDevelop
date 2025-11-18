package com.springdiaryproject.springdiarydevelop.controller;

import com.springdiaryproject.springdiarydevelop.dto.comment.CreateCommentRequest;
import com.springdiaryproject.springdiarydevelop.dto.comment.CreateCommentResponse;
import com.springdiaryproject.springdiarydevelop.dto.comment.ReadCommentResponse;
import com.springdiaryproject.springdiarydevelop.dto.login.LoginSessionInfo;
import com.springdiaryproject.springdiarydevelop.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class CommentController {
    CommentService service;
    @PostMapping("/schedules/{scheduleId}")
    public ResponseEntity<CreateCommentResponse> create(HttpServletRequest servletRequest, @RequestParam Long scheduleId, @RequestBody CreateCommentRequest request) {
        LoginSessionInfo info = (LoginSessionInfo)servletRequest.getSession().getAttribute("user");
        CreateCommentResponse result = service.create(info, scheduleId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<List<ReadCommentResponse>> read(HttpServletRequest servletRequest, @RequestParam Long scheduleId) {
        List<ReadCommentResponse> result = service.read(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
