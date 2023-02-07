package com.hackathon.daechelinguide.domain.comment.service;

import com.hackathon.daechelinguide.domain.comment.domain.repository.CommentRepository;
import com.hackathon.daechelinguide.domain.menu.domain.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MenuRepository menuRepository;

    public
}
