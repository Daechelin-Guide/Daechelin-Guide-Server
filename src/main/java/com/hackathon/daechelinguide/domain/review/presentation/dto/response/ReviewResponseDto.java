package com.hackathon.daechelinguide.domain.review.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponseDto {
    private Integer star;
    private String menu;
    private String date;
}
