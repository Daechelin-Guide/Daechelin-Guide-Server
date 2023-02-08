package com.hackathon.daechelinguide.domain.comment.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
    private String message;
    private String date;
    private String menu;
}
