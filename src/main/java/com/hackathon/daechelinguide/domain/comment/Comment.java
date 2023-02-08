package com.hackathon.daechelinguide.domain.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String message;
    private String date;
    private String menu;
    @CreatedDate
    @JsonFormat(pattern = "yyyy년 MM월 dd일 E요일")
    private LocalDate createdDate;
}
