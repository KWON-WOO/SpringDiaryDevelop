package com.springdiaryproject.springdiarydevelop.repository;

import com.springdiaryproject.springdiarydevelop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
