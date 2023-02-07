package com.hackathon.daechelinguide.domain.menu.presentation;

import com.hackathon.daechelinguide.domain.menu.presentation.dto.api.MenuResponseDto;
import com.hackathon.daechelinguide.global.config.AppProperties;
import com.hackathon.daechelinguide.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MenuController {

    private final AppProperties app;
    private final MenuService webClientService;
    private final WebClient webClient;

    @GetMapping(value = "/menu", produces = "application/json;charset=UTF-8")
    public MenuResponseDto test(@RequestParam String year, @RequestParam String month, @RequestParam String day){
        return webClientService.findMenu(year, month, day);
    }
}