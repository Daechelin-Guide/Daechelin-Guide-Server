package com.hackathon.daechelinguide.domain.review.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewRequestDto {
    private double star;
    private String menus;
}
