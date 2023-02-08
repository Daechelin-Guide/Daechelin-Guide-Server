package com.hackathon.daechelinguide.domain.menu.presentation.dto.api;

import com.hackathon.daechelinguide.domain.menu.Menu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OpenApiInfoDto {
    private String date;
    private String breakfast;

    private String lunch;
    private String dinner;

    private String week;

    public OpenApiInfoDto(OpenApiInfoDto data) {
        final SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.date = data.getDate();
        this.breakfast = data.getBreakfast();
        this.dinner = data.getDinner();
        this.lunch = data.getLunch();
        final Date parsedDate;
        try {
            parsedDate = parseFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
        this.week = dateFormat.format(parsedDate);
    }

    public static Menu toEntity(OpenApiInfoDto data) {
        return Menu.builder()
                .date(data.getDate())
                .breakfast(data.getBreakfast())
                .dinner(data.getDinner())
                .lunch(data.getLunch())
                .week(LocalDate.parse(data.getDate()))
                .build();
    }
}
