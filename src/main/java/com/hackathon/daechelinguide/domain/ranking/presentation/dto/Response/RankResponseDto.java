package com.hackathon.daechelinguide.domain.ranking.presentation.dto.Response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.ZSetOperations;

@Data
@NoArgsConstructor
public class RankResponseDto {
    private String menu;
    private int score;
    public static RankResponseDto convertToResponseRankingDto(ZSetOperations.TypedTuple typedTuple){
        RankResponseDto responseRankingDto=new RankResponseDto();
        responseRankingDto.menu=typedTuple.getValue().toString();
        responseRankingDto.score=typedTuple.getScore().intValue();
        return responseRankingDto;
    }
}
