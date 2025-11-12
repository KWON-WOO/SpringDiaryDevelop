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

//    @Transactional
//    public ReadScheduleResponse readSchedule(ReadScheduleRequest request) {
//        Schedule schedule = new Schedule(request);
//
//        return new ReadScheduleResponse();
//
//    }
}
