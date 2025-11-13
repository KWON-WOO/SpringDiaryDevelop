package com.springdiaryproject.springdiarydevelop.service;

import com.springdiaryproject.springdiarydevelop.dto.Schedule.*;
import com.springdiaryproject.springdiarydevelop.entity.Schedule;
import com.springdiaryproject.springdiarydevelop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository repository;

    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(request);
        ScheduleDto dto = new ScheduleDto(repository.save(schedule));
        return new CreateScheduleResponse(dto);
    }

    @Transactional(readOnly = true)
    public ReadScheduleResponse read(Long id) {
        Schedule schedule = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("잘못된 입력값.")
        );
        return new ReadScheduleResponse(new ScheduleDto(schedule));
    }

    @Transactional
    public UpdateScheduleResponse update(Long id, UpdateScheduleRequest request) {
        Schedule schedule = getSchedule(id);
        if (!request.getName().isEmpty()) schedule.setName(request.getName());
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
                () -> new IllegalArgumentException("잘못된 값")
        );
    }

}
