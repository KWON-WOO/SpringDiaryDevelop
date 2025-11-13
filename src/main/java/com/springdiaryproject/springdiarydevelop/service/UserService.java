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

    @Transactional
    public UpdateUserResponse update(Long id, UpdateUserRequest request) {
        User user = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("유저 없음.")
        );
        if (!request.getName().isEmpty()) user.setName(request.getName());
        if (!request.getEmail().isEmpty()) user.setEmail(request.getEmail());
        return new UpdateUserResponse(new UserDto(user));
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
