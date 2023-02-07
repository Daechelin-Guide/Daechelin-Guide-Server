package com.hackathon.daechelinguide.domain.menu.service;

import com.hackathon.daechelinguide.domain.menu.domain.repository.MenuRepository;
import com.hackathon.daechelinguide.domain.menu.presentation.dto.api.MenuResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final WebClient webClient;
    private final MenuRepository menuRepository;

    public MenuResponseDto findMenu(String year, String month, String day){
        MenuResponseDto menuResponseDto = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("year", year)
                        .queryParam("month", month)
                        .queryParam("day", day)
                        .build())
                .retrieve()
                .bodyToMono(MenuResponseDto.class)
                .block();
        return menuResponseDto;
    }
}
