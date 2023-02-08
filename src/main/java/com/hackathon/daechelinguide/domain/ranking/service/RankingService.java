package com.hackathon.daechelinguide.domain.ranking.service;

import com.hackathon.daechelinguide.domain.ranking.presentation.dto.Response.RankResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RankingService {

    private final RedisTemplate<String, String> redisTemplate;

    // 인기검색어 리스트 1위~10위까지
    public List<RankResponseDto> getRankingList() {
        String key = "ranking";
        ZSetOperations<String, String> ZSetOperations = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> typedTuples = ZSetOperations.reverseRangeWithScores(key, 0, 9);  //score순으로 10개 보여줌
        return typedTuples.stream().map(RankResponseDto::convertToResponseRankingDto).collect(Collectors.toList());
    }

}
