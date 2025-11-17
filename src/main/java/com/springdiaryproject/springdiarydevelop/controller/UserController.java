package com.springdiaryproject.springdiarydevelop.controller;

import com.springdiaryproject.springdiarydevelop.dto.user.*;
import com.springdiaryproject.springdiarydevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/signup")
    public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest request) {
        CreateUserResponse result = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/users")
    public ResponseEntity<ReadUserResponse> read(@RequestParam String name) {
        ReadUserResponse result = service.read(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/users")
    public ResponseEntity<UpdateUserResponse> update(@RequestParam Long id, @RequestBody UpdateUserRequest request) {
        UpdateUserResponse result = service.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/users")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
