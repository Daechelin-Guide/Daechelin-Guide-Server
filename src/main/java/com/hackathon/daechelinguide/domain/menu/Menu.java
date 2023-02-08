package com.hackathon.daechelinguide.domain.menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@AllArgsConstructor @NoArgsConstructor
public class Menu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    private String date;

    private String breakfast;

    private String lunch;

    private String dinner;
    @JsonFormat(pattern = "yyyy년 MM월 dd일 E요일")
    private LocalDate week;

}
