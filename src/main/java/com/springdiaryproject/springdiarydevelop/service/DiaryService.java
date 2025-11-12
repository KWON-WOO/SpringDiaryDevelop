package com.springdiaryproject.springdiarydevelop.service;

import com.springdiaryproject.springdiarydevelop.dto.*;
import com.springdiaryproject.springdiarydevelop.entity.Schedule;
import com.springdiaryproject.springdiarydevelop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateScheduleResponse saveSchedule(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(request);
        ScheduleDto dto = new ScheduleDto(scheduleRepository.save(schedule));
        return new CreateScheduleResponse(dto);
    }

    @Transactional(readOnly = true)
    public ReadScheduleResponse readSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("잘못된 입력값.")
        );
        return new ReadScheduleResponse(new ScheduleDto(schedule));
    }

    @Transactional
    public UpdateScheduleResponse updateSchedule(Long id, UpdateScheduleRequest request) {
        Schedule schedule = getSchedule(id);
        if (!request.getName().isEmpty()) schedule.setName(request.getName());
        if (!request.getTitle().isEmpty()) schedule.setTitle(request.getTitle());
        if (!request.getContent().isEmpty()) schedule.setContent(request.getContent());

        return new UpdateScheduleResponse(new ScheduleDto(schedule));
    }

    @Transactional
    public void deleteSchedule(Long id) {
        scheduleRepository.delete(getSchedule(id));

    }

    public Schedule getSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("잘못된 값")
        );
    }

}
