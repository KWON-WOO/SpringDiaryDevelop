package com.springdiaryproject.springdiarydevelop.service;

import com.springdiaryproject.springdiarydevelop.Config.PasswordEncoder;
import com.springdiaryproject.springdiarydevelop.dto.login.LoginDto;
import com.springdiaryproject.springdiarydevelop.dto.login.LoginInfo;
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
    private final PasswordEncoder passwordEncoder;
    HttpSession session;
    @Transactional
    public String login(HttpServletRequest servletRequest, @RequestBody LoginDto loginRequest) {
        String passwordEncoding = passwordEncoder.encode(loginRequest.getPassword());
        User user = repository.findByEmailAndPassword(loginRequest.getEmail(), passwordEncoding).orElseThrow(
                () -> new IllegalArgumentException("아이디나 비번이 틀림")
        );
        LoginInfo info = new LoginInfo(user.getId(), user.getName(), user.getEmail());
        HttpSession session = servletRequest.getSession();
        session.setAttribute("user", loginRequest);

        return "로그인 성공";
    }
}
