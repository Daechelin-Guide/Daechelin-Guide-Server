package com.hackathon.daechelinguide.domain.review.service;

import com.hackathon.daechelinguide.domain.menu.domain.repository.MenuRepository;
import com.hackathon.daechelinguide.domain.review.Review;
import com.hackathon.daechelinguide.domain.review.domain.repository.ReviewRepository;
import com.hackathon.daechelinguide.domain.review.presentation.dto.request.ReviewRequestDto;
import com.hackathon.daechelinguide.domain.review.presentation.dto.response.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final MenuRepository menuRepository;
    private final ReviewRepository reviewRepository;
    private final RedisTemplate<String, String> redisTemplate;

    public Review registration(ReviewRequestDto reviewRequestDto){
        return reviewRepository.save(Review.builder()
                .menu(reviewRequestDto.getMenus())
                .date(menuRepository.findByDates(reviewRequestDto.getMenus()))
                .star(reviewRequestDto.getStar())
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
    public List<Review> ranks(){
        return reviewRepository.findAllByStar();
    }
}
