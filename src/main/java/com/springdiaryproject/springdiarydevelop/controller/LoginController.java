package com.springdiaryproject.springdiarydevelop.controller;

import com.springdiaryproject.springdiarydevelop.dto.LoginRequest;
import com.springdiaryproject.springdiarydevelop.entity.User;
import com.springdiaryproject.springdiarydevelop.service.LoginService;
import com.springdiaryproject.springdiarydevelop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final LoginService service;

    @PostMapping
    public ResponseEntity<Void> login(HttpServletRequest servletRequest, @RequestBody LoginRequest loginRequest) {
        service.login(servletRequest, loginRequest);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
