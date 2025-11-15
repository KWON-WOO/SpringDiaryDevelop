package com.springdiaryproject.springdiarydevelop.controller;

import com.springdiaryproject.springdiarydevelop.dto.Login.LoginInfo;
import com.springdiaryproject.springdiarydevelop.dto.Schedule.*;
import com.springdiaryproject.springdiarydevelop.service.ScheduleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService service;

    @PostMapping
    public ResponseEntity<CreateScheduleResponse> create(HttpServletRequest servletRequest, @RequestBody CreateScheduleRequest request) {
        HttpSession session = servletRequest.getSession();
        LoginInfo info = (LoginInfo)session.getAttribute("user");
        CreateScheduleResponse response = service.save(info.getName(), request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ReadScheduleResponse> read(@RequestParam Long id) {
        ReadScheduleResponse result = service.read(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping
    public ResponseEntity<UpdateScheduleResponse> update(@RequestParam Long id, @RequestBody UpdateScheduleRequest request) {
        UpdateScheduleResponse result = service.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
