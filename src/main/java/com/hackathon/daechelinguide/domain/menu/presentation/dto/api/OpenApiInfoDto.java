package com.hackathon.daechelinguide.domain.menu.presentation.dto.api;

import com.hackathon.daechelinguide.domain.menu.Menu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OpenApiInfoDto {
    private String date;
    private String breakfast;
    private String dinner;
    private String lunch;

    public OpenApiInfoDto(OpenApiInfoDto data) {
        this.date = data.getDate();
        this.breakfast = data.getBreakfast();
        this.dinner = data.getDinner();
        this.lunch = data.getLunch();
    }

    public static Menu toEntity(OpenApiInfoDto data) {
        return Menu.builder()
                .date(data.getDate())
                .breakfast(data.getBreakfast())
                .dinner(data.getDinner())
                .lunch(data.getLunch())
                .build();
    }
}
