package com.springdiaryproject.springdiarydevelop.controller;

import com.springdiaryproject.springdiarydevelop.dto.login.LoginSessionInfo;
import com.springdiaryproject.springdiarydevelop.dto.schedule.*;
import com.springdiaryproject.springdiarydevelop.service.ScheduleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService service;

    @PostMapping
    public ResponseEntity<CreateScheduleResponse> create(HttpServletRequest servletRequest, @RequestBody CreateScheduleRequest request) {
        HttpSession session = servletRequest.getSession();
        LoginSessionInfo info = (LoginSessionInfo)session.getAttribute("user");
        CreateScheduleResponse response = service.save(info, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadScheduleResponse> read(@PathVariable Long id) {
        ReadScheduleResponse result = service.read(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<Page<ReadSchedulePageResponse>> readScheduleList(@SessionAttribute(name="user", required=false) LoginSessionInfo session,
                                                                           @RequestParam(required = false, defaultValue = "0", value="page") int pageNo,
                                                                           @RequestParam(required = false, defaultValue = "10", value="size") int pageSize) {
        return ResponseEntity.status(HttpStatus.OK).body(service.readScheduleList(session, pageNo, pageSize));
    }

    @PatchMapping
    public ResponseEntity<UpdateScheduleResponse> update(@RequestParam Long id, @RequestBody UpdateScheduleRequest request) {
        UpdateScheduleResponse result = service.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
