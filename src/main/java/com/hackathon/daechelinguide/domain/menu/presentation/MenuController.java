package com.hackathon.daechelinguide.domain.menu.presentation;

import com.hackathon.daechelinguide.domain.menu.presentation.dto.api.OpenApiDataDto;
import com.hackathon.daechelinguide.domain.menu.presentation.dto.response.BreakfastResponseDto;
import com.hackathon.daechelinguide.domain.menu.presentation.dto.response.DinnerResponseDto;
import com.hackathon.daechelinguide.domain.menu.presentation.dto.response.LunchResponseDto;
import com.hackathon.daechelinguide.domain.menu.service.MenuService;
import com.hackathon.daechelinguide.global.config.AppProperties;
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
    public OpenApiDataDto test(@RequestParam String year, @RequestParam String month, @RequestParam String day){
        return webClientService.findMenu(year, month, day);
    }

    @GetMapping("/break")
    public BreakfastResponseDto findBreak(@RequestParam String date){
        return webClientService.findBreak(date);
    }

    @GetMapping("/lunch")
    public LunchResponseDto findLunch(@RequestParam String date){
        return webClientService.findLunch(date);
    }

    @GetMapping("/dinner")
    public DinnerResponseDto findDinner(@RequestParam String date){
        return webClientService.findDinner(date);
    }
}