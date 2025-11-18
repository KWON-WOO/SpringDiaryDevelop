package com.springdiaryproject.springdiarydevelop.service;

import com.springdiaryproject.springdiarydevelop.Config.PasswordEncoder;
import com.springdiaryproject.springdiarydevelop.dto.login.LoginDto;
import com.springdiaryproject.springdiarydevelop.dto.login.LoginSessionInfo;
import com.springdiaryproject.springdiarydevelop.entity.User;
import com.springdiaryproject.springdiarydevelop.exception.CustomException;
import com.springdiaryproject.springdiarydevelop.exception.StateCode;
import com.springdiaryproject.springdiarydevelop.repository.UserRepository;
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
    public LoginSessionInfo login(@RequestBody LoginDto loginRequest) {

        User user = repository.findByEmail(loginRequest.getEmail()).orElseThrow(
                () -> new CustomException(StateCode.BAD_REQUEST)
        );

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new CustomException(StateCode.UNAUTHORIZED);
        }

        return new LoginSessionInfo(user.getId(), user.getName(), user.getEmail());
    }
}