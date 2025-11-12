package com.springdiaryproject.springdiarydevelop.controller;

import com.springdiaryproject.springdiarydevelop.dto.*;
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

    @GetMapping("/schedules")
    public ResponseEntity<ReadScheduleResponse> readSchedule(@RequestParam Long id){
        ReadScheduleResponse result = diaryService.readSchedule(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/schedules")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@RequestParam Long id, @RequestBody UpdateScheduleRequest request){
        UpdateScheduleResponse result = diaryService.updateSchedule(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
