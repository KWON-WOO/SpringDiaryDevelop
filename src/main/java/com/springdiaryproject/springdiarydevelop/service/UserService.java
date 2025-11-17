package com.springdiaryproject.springdiarydevelop.service;

import com.springdiaryproject.springdiarydevelop.Config.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public CreateUserResponse create(CreateUserRequest request) {
        if(!repository.existsByEmail(request.getEmail())) {
            String passwordEncoding = passwordEncoder.encode(request.getPassword());
            request.setPassword(passwordEncoding);
            User user = new User(request);
            UserDto dto = UserDto.of(repository.save(user));
            return new CreateUserResponse(dto);
        } else {
            throw new IllegalArgumentException("이미 존재하는 유저");
        }
    }

    @Transactional
    public ReadUserResponse read(String name) {
        User user = repository.findByName(name).orElseThrow(
                () -> new IllegalArgumentException("NotFoundName")
        );
        return new ReadUserResponse(UserDto.of(user));
    }

    @Transactional
    public UpdateUserResponse update(Long id, UpdateUserRequest request) {
        User user = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("유저 없음.")
        );
        if (!request.getName().isEmpty()) user.setName(request.getName());
        if (!request.getEmail().isEmpty()) user.setEmail(request.getEmail());
        return new UpdateUserResponse(UserDto.of(user));
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
