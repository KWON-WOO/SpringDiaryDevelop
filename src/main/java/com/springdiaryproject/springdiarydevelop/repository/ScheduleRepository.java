package com.springdiaryproject.springdiarydevelop.repository;

import com.springdiaryproject.springdiarydevelop.dto.schedule.ReadSchedulePageResponse;
import com.springdiaryproject.springdiarydevelop.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("""
            SELECT new com.springdiaryproject.springdiarydevelop.dto.schedule.ReadSchedulePageResponse(
                        s.title,
                        s.content,
                        COUNT(c),
                        s.createdAt,
                        s.modifiedAt,
                        s.user.name
                        )
                        FROM Schedule s
                        LEFT JOIN Comment c ON c.schedule = s
                        GROUP BY s.title, s.content, s.createdAt, s.modifiedAt, s.user.name
                        
            """)
    Page<ReadSchedulePageResponse> findAllScheduleWithCommentCount(Pageable pageable);
}