package com.hackathon.daechelinguide.domain.menu.service;

import com.hackathon.daechelinguide.domain.menu.Menu;
import com.hackathon.daechelinguide.domain.menu.domain.repository.MenuRepository;
import com.hackathon.daechelinguide.domain.menu.presentation.dto.api.OpenApiDataDto;
import com.hackathon.daechelinguide.domain.menu.presentation.dto.api.OpenApiInfoDto;
import com.hackathon.daechelinguide.domain.menu.presentation.dto.response.BreakfastResponseDto;
import com.hackathon.daechelinguide.domain.menu.presentation.dto.response.DinnerResponseDto;
import com.hackathon.daechelinguide.domain.menu.presentation.dto.response.LunchResponseDto;
import com.hackathon.daechelinguide.global.exception.BusinessException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService {
    private final WebClient webClient;
    private final MenuRepository menuRepository;

    public OpenApiDataDto findMenu(String year, String month, String day){
        OpenApiDataDto openApiDataDto = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("year", year)
                        .queryParam("month", month)
                        .queryParam("day", day)
                        .build())
                .retrieve()
                .bodyToMono(OpenApiDataDto.class)
                .block();
        if(menuRepository.existsByDate(openApiDataDto.getOpenApiInfoDto().getDate())) {
            log.info("중복된거 컷!");
            return openApiDataDto;
        }
        save(openApiDataDto);
        return openApiDataDto;
    }
    @Transactional
    public void save(OpenApiDataDto openApiDataDto){
        OpenApiInfoDto data = openApiDataDto.getOpenApiInfoDto();
        Menu menu = OpenApiInfoDto.toEntity(data);
        menuRepository.save(menu);
    }

    public BreakfastResponseDto findBreak(String date){
        Menu menu = menuRepository.findByDate(date)
                .orElseThrow(() ->
                        new BusinessException(HttpStatus.NOT_FOUND, "급식이 존재하지 않습니다.")
                );
        return BreakfastResponseDto.builder()
                .breakfast(menu.getBreakfast())
                .build();
    }

    public LunchResponseDto findLunch(String date){
        Menu menu = menuRepository.findByDate(date)
                .orElseThrow(() ->
                        new BusinessException(HttpStatus.NOT_FOUND, "급식이 존재하지 않습니다.")
                );
        return LunchResponseDto.builder()
                .Lunch(menu.getLunch())
                .build();
    }

    public DinnerResponseDto findDinner(String date){
        Menu menu = menuRepository.findByDate(date)
                .orElseThrow(() ->
                        new BusinessException(HttpStatus.NOT_FOUND, "급식이 존재하지 않습니다.")
                );
        return DinnerResponseDto.builder()
                .Dinner(menu.getDinner())
                .build();
    }
}
