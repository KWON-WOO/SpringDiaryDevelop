package com.springdiaryproject.springdiarydevelop.controller;

import com.springdiaryproject.springdiarydevelop.dto.Schedule.*;
import com.springdiaryproject.springdiarydevelop.dto.User.CreateUserRequest;
import com.springdiaryproject.springdiarydevelop.dto.User.CreateUserResponse;
import com.springdiaryproject.springdiarydevelop.dto.User.ReadUserResponse;
import com.springdiaryproject.springdiarydevelop.service.ScheduleService;
import com.springdiaryproject.springdiarydevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final ScheduleService scheduleService;
    private final UserService userService;

    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request){
        CreateScheduleResponse response = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/schedules")
    public ResponseEntity<ReadScheduleResponse> readSchedule(@RequestParam Long id){
        ReadScheduleResponse result = scheduleService.read(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/schedules")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@RequestParam Long id, @RequestBody UpdateScheduleRequest request){
        UpdateScheduleResponse result = scheduleService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @DeleteMapping("/schedules")
    public ResponseEntity<Void> deleteSchedule(@RequestParam Long id){
        scheduleService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/users")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        CreateUserResponse result = userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/users")
    public ResponseEntity<ReadUserResponse> readUser(@RequestParam String name){
        ReadUserResponse result = userService.read(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
