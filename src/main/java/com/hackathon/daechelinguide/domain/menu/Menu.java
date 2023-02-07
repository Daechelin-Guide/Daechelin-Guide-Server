package com.hackathon.daechelinguide.domain.menu;

import com.hackathon.daechelinguide.domain.review.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private String week;
}
