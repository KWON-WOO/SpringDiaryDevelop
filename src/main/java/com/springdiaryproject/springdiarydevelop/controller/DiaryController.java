package com.springdiaryproject.springdiarydevelop.controller;

import com.springdiaryproject.springdiarydevelop.dto.CreateScheduleRequest;
import com.springdiaryproject.springdiarydevelop.dto.CreateScheduleResponse;
import com.springdiaryproject.springdiarydevelop.dto.ReadScheduleResponse;
import com.springdiaryproject.springdiarydevelop.service.DiaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request){
        CreateScheduleResponse response = diaryService.saveSchedule(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ReadScheduleResponse> readSchedule(@RequestParam @Valid String name){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadScheduleResponse());
    }
}
