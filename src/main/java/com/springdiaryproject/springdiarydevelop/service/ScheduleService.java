package com.springdiaryproject.springdiarydevelop.service;

import com.springdiaryproject.springdiarydevelop.dto.login.LoginSessionInfo;
import com.springdiaryproject.springdiarydevelop.dto.schedule.*;
import com.springdiaryproject.springdiarydevelop.entity.Schedule;
import com.springdiaryproject.springdiarydevelop.entity.User;
import com.springdiaryproject.springdiarydevelop.exception.CustomException;
import com.springdiaryproject.springdiarydevelop.exception.StateCode;
import com.springdiaryproject.springdiarydevelop.repository.ScheduleRepository;
import com.springdiaryproject.springdiarydevelop.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository repository;
    private final UserRepository userRepository;
    @Transactional
    public CreateScheduleResponse save(LoginSessionInfo info, CreateScheduleRequest request) {
        User user = userRepository.findById(info.getId()).orElseThrow(
                () -> new CustomException(StateCode.UNAUTHORIZED)
        );
        Schedule schedule = new Schedule(user, request);
        ScheduleDto dto = new ScheduleDto(repository.save(schedule));
        return new CreateScheduleResponse(dto);
    }

    @Transactional(readOnly = true)
    public ReadScheduleResponse read(Long id) {
        Schedule schedule = getSchedule(id);
        return new ReadScheduleResponse(new ScheduleDto(schedule));
    }

    @Transactional(readOnly=true)
    public Page<ReadSchedulePageResponse> readScheduleList(LoginSessionInfo session, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "modifiedAt"));
        Page<ReadSchedulePageResponse> dtos = repository.findAllScheduleWithCommentCount(pageable);
        return dtos;
    }

    @Transactional
    public UpdateScheduleResponse update(Long id, UpdateScheduleRequest request) {
        Schedule schedule = getSchedule(id);
        if (!request.getTitle().isEmpty()) schedule.setTitle(request.getTitle());
        if (!request.getContent().isEmpty()) schedule.setContent(request.getContent());

        return new UpdateScheduleResponse(new ScheduleDto(schedule));
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(getSchedule(id));

    }

    public Schedule getSchedule(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new CustomException(StateCode.BAD_REQUEST)
        );
    }

}
