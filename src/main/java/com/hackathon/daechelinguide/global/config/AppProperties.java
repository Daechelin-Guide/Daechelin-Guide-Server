package com.hackathon.daechelinguide.global.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private String baseUrl;
    private String apiKey;
    private String scCode;
    private String schoolCode;
    private String type;
}
