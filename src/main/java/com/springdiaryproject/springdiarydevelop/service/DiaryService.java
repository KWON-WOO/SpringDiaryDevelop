package com.springdiaryproject.springdiarydevelop.service;

import com.springdiaryproject.springdiarydevelop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final ScheduleRepository scheduleRepository;
}
