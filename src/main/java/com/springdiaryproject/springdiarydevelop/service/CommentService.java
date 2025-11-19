package com.springdiaryproject.springdiarydevelop.service;

import com.springdiaryproject.springdiarydevelop.dto.comment.*;
import com.springdiaryproject.springdiarydevelop.dto.login.LoginSessionInfo;
import com.springdiaryproject.springdiarydevelop.entity.Comment;
import com.springdiaryproject.springdiarydevelop.entity.Schedule;
import com.springdiaryproject.springdiarydevelop.entity.User;
import com.springdiaryproject.springdiarydevelop.exception.CustomException;
import com.springdiaryproject.springdiarydevelop.exception.StateCode;
import com.springdiaryproject.springdiarydevelop.repository.CommentRepository;
import com.springdiaryproject.springdiarydevelop.repository.ScheduleRepository;
import com.springdiaryproject.springdiarydevelop.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    @Transactional
    public CreateCommentResponse create(LoginSessionInfo session, Long scheduleId , CreateCommentRequest request) {
        Schedule schedule = getSchedule(session.getId());
        User user = getUser(session.getId());
        Comment comment = commentRepository.save(Comment.of(schedule, user, request));
        return new CreateCommentResponse(CommentDto.of(comment));
    }

    @Transactional
    public List<ReadCommentResponse> read(Long id) {
        List<Comment> comments = commentRepository.findAllByScheduleIdOrderByModifiedAtDesc(id);
        List<ReadCommentResponse> responses = new ArrayList<>();

        for (Comment comment: comments) {
            responses.add(new ReadCommentResponse(CommentDto.of(comment)));
        }
        return responses;
    }

    @Transactional
    public UpdateCommentResponse update(LoginSessionInfo session, Long id, UpdateCommentRequest request) {
        if (!scheduleRepository.existsById(id)) {
            throw new CustomException(StateCode.NOT_FOUND);
        }
        Comment comment = getComment(request.getCommentId());

        if (!(session.getId() == comment.getUser().getId())) {
            throw new CustomException(StateCode.FORBIDDEN);
        }

        comment.setComment(request.getComment());

        return new UpdateCommentResponse(CommentDto.of(comment));
    }

    public Schedule getSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(
                () -> new CustomException(StateCode.FORBIDDEN)
        );
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new CustomException(StateCode.FORBIDDEN)
        );
    }

    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElseThrow(
                () -> new CustomException(StateCode.FORBIDDEN)
        );
    }
}
