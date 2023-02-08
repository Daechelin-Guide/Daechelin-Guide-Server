package com.hackathon.daechelinguide.domain.comment.service;

import com.hackathon.daechelinguide.domain.comment.Comment;
import com.hackathon.daechelinguide.domain.comment.domain.repository.CommentRepository;
import com.hackathon.daechelinguide.domain.comment.presentation.dto.request.CommentRequestDto;
import com.hackathon.daechelinguide.domain.menu.domain.repository.MenuRepository;
import com.hackathon.daechelinguide.global.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MenuRepository menuRepository;

    public Comment register(CommentRequestDto commentRequestDto){
        return commentRepository.save(Comment.builder()
                .createdDate(LocalDate.now())
                .message(commentRequestDto.getMessage())
                .date(menuRepository.findByDates(commentRequestDto.getMenu()))
                .menu(commentRequestDto.getMenu())
                .build());
    }

    public List<Comment> findComment(String menu){
        String date = menuRepository.findByDates(menu);
        return commentRepository.findByMessage(menu, date).orElseThrow(()
                -> new BusinessException(HttpStatus.NOT_FOUND, "댓글이 존재하지 않습니다.")
        );
    }
}
