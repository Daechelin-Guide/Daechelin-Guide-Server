package com.hackathon.daechelinguide.domain.comment.presentation;

import com.hackathon.daechelinguide.domain.comment.Comment;
import com.hackathon.daechelinguide.domain.comment.presentation.dto.request.CommentRequestDto;
import com.hackathon.daechelinguide.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/regis")
    public Comment register(@RequestBody CommentRequestDto commentRequestDto){
        return commentService.register(commentRequestDto);
    }

    @GetMapping("/message")
    public List<Comment> findMessage(@RequestParam String menu){
        return commentService.findComment(menu);
    }
}
