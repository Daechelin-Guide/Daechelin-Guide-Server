package com.hackathon.daechelinguide.domain.review.presentation;

import com.hackathon.daechelinguide.domain.review.Review;
import com.hackathon.daechelinguide.domain.review.presentation.dto.request.ReviewReuestDto;
import com.hackathon.daechelinguide.domain.review.presentation.dto.response.ReviewResponseDto;
import com.hackathon.daechelinguide.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/regis")
    public Review registration(@RequestBody ReviewReuestDto reviewReuestDto){
        return reviewService.registration(reviewReuestDto);
    }

    @GetMapping("/star")
    public ReviewResponseDto findStar(@RequestParam String menu){
        return reviewService.findStar(menu);
    }
}
