package com.hackathon.daechelinguide.domain.menu.service;

import com.hackathon.daechelinguide.domain.menu.domain.repository.MenuRepository;
import com.hackathon.daechelinguide.domain.menu.presentation.dto.api.OpenApiDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final WebClient webClient;
    private final MenuRepository menuRepository;

    public OpenApiDataDto findMenu(String year, String month, String day){
        OpenApiDataDto menuResponseDto = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("year", year)
                        .queryParam("month", month)
                        .queryParam("day", day)
                        .build())
                .retrieve()
                .bodyToMono(OpenApiDataDto.class)
                .block();
        return menuResponseDto;
    }
}
