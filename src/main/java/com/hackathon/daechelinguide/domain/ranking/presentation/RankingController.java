package com.hackathon.daechelinguide.domain.ranking.presentation;

import com.hackathon.daechelinguide.domain.ranking.presentation.dto.Response.RankResponseDto;
import com.hackathon.daechelinguide.domain.ranking.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RankingController {
    private final RedisTemplate<String, String> redisTemplate;
    private final RankingService rankingService;

    @GetMapping("/ranking")
    public List<RankResponseDto> getRankingList() {
        return rankingService.getRankingList();
    }
}
