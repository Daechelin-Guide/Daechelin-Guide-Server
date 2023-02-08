package com.hackathon.daechelinguide.domain.review.presentation;

import com.hackathon.daechelinguide.domain.review.Review;
import com.hackathon.daechelinguide.domain.review.presentation.dto.request.ReviewRequestDto;
import com.hackathon.daechelinguide.domain.review.presentation.dto.response.ReviewResponseDto;
import com.hackathon.daechelinguide.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/regis")
    public Review registration(@RequestBody ReviewRequestDto reviewReuestDto){
        return reviewService.registration(reviewReuestDto);
    }

    @GetMapping("/star")
    public ReviewResponseDto findStar(@RequestParam String menu){
        return reviewService.findStar(menu);
    }

    @GetMapping("/rank")
    public List<Review> ranking(@RequestParam String menu){
        return reviewService.ranks();
    }
}
