package com.hackathon.daechelinguide.domain.review.presentation.dto.request;

import com.hackathon.daechelinguide.domain.menu.Menu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewReuestDto {
    private Integer star;
    private String menus;
}
