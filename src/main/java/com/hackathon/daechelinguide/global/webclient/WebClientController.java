package com.hackathon.daechelinguide.global.webclient;

import com.hackathon.daechelinguide.global.config.AppProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebClientController {

    private final AppProperties app;

    @GetMapping(value = "/test", produces = "application/json; charset=utf8")
    public Mono<String> test(@RequestParam String data){
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(app.getBaseUrl());
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);

        WebClient webClient = WebClient.builder()
                .uriBuilderFactory(factory)
                .baseUrl(app.getBaseUrl())
                .build();


        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                            .queryParam("Type", app.getType())
                            .queryParam("ATPT_OFCDC_SC_CODE", app.getScCode())
                            .queryParam("SD_SCHUL_CODE", app.getSchoolCode())
                            .queryParam("Key", app.getApiKey())
                            .queryParam("MLSV_YMD", data)
                            .build())
                .retrieve()
                .bodyToMono(String.class);

    }
}
