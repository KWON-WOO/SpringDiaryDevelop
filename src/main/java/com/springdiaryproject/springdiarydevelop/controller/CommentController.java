package com.springdiaryproject.springdiarydevelop.controller;

import com.springdiaryproject.springdiarydevelop.dto.comment.*;
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
    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CreateCommentResponse> create(HttpServletRequest servletRequest, @RequestParam Long scheduleId, @RequestBody CreateCommentRequest request) {
        LoginSessionInfo info = (LoginSessionInfo)servletRequest.getSession().getAttribute("user");
        CreateCommentResponse result = service.create(info, scheduleId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<List<ReadCommentResponse>> read(@RequestParam Long scheduleId) {
        List<ReadCommentResponse> result = service.read(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<UpdateCommentResponse> update(HttpServletRequest servletRequest, @RequestParam Long scheduleId, @RequestBody UpdateCommentRequest request) {
        LoginSessionInfo info = (LoginSessionInfo)servletRequest.getSession().getAttribute("user");
        UpdateCommentResponse result = service.update(info, scheduleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/schedules/{}/comments")
    public ResponseEntity<Void> delete(HttpServletRequest servletRequest, @RequestBody DeleteCommentRequest request) {
        LoginSessionInfo info = (LoginSessionInfo)servletRequest.getSession().getAttribute("user");
        service.delete(info, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
