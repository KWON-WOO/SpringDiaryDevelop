package com.springdiaryproject.springdiarydevelop.controller;

import com.springdiaryproject.springdiarydevelop.dto.Schedule.*;
import com.springdiaryproject.springdiarydevelop.dto.User.*;
import com.springdiaryproject.springdiarydevelop.service.ScheduleService;
import com.springdiaryproject.springdiarydevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        CreateUserResponse result = userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/users")
    public ResponseEntity<ReadUserResponse> readUser(@RequestParam String name) {
        ReadUserResponse result = userService.read(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/users")
    public ResponseEntity<UpdateUserResponse> update(@RequestParam Long id, @RequestBody UpdateUserRequest request) {
        UpdateUserResponse result = userService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/users")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
