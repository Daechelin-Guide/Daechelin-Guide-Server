package com.hackathon.daechelinguide.domain.review.service;

import com.hackathon.daechelinguide.domain.menu.domain.repository.MenuRepository;
import com.hackathon.daechelinguide.domain.review.Review;
import com.hackathon.daechelinguide.domain.review.domain.repository.ReviewRepository;
import com.hackathon.daechelinguide.domain.review.presentation.dto.request.ReviewReuestDto;
import com.hackathon.daechelinguide.domain.review.presentation.dto.response.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final MenuRepository menuRepository;
    private final ReviewRepository reviewRepository;

    public Review registration(ReviewReuestDto reviewReuestDto){
        return reviewRepository.save(Review.builder()
                .menu(reviewReuestDto.getMenus())
                .date(menuRepository.findByDates(reviewReuestDto.getMenus()))
                .star(reviewReuestDto.getStar())
                .build());
    }
    public ReviewResponseDto findStar(String menu){
        String date = menuRepository.findByDates(menu);
        return ReviewResponseDto.builder()
                .star(reviewRepository.findByDateAndMenu(date, menu))
                .date(date)
                .menu(menu)
                .build();
    }

}
