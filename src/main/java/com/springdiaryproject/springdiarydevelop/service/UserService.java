package com.springdiaryproject.springdiarydevelop.service;

import com.springdiaryproject.springdiarydevelop.dto.User.*;
import com.springdiaryproject.springdiarydevelop.entity.User;
import com.springdiaryproject.springdiarydevelop.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    @Transactional
    public CreateUserResponse create(CreateUserRequest request) {
        User user = new User(request);
        UserDto dto = new UserDto(repository.save(user));
        return new CreateUserResponse(dto);
    }
    @Transactional
    public ReadUserResponse read(String name) {
        User user = repository.findByName(name).orElseThrow(
                () -> new IllegalArgumentException("NotFoundName")
        );

        return new ReadUserResponse(new UserDto(user));

    }
}
