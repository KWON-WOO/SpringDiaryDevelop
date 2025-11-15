package com.springdiaryproject.springdiarydevelop.service;

import com.springdiaryproject.springdiarydevelop.dto.Login.LoginDto;
import com.springdiaryproject.springdiarydevelop.dto.Login.LoginInfo;
import com.springdiaryproject.springdiarydevelop.entity.User;
import com.springdiaryproject.springdiarydevelop.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository repository;
    HttpSession session;
    @Transactional
    public String login(HttpServletRequest servletRequest, @RequestBody LoginDto loginRequest) {
        User user = repository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()).orElseThrow(
                () -> new IllegalArgumentException("아이디나 비번이 틀림")
        );
        LoginInfo info = new LoginInfo(user.getId(), user.getName(), user.getEmail());
        HttpSession session = servletRequest.getSession();
        session.setAttribute("user", loginRequest);

        return "로그인 성공";
    }
}
