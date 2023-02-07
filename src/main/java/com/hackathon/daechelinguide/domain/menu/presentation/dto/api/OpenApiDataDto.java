package com.hackathon.daechelinguide.domain.menu.presentation.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OpenApiDataDto implements Serializable {
    @JsonProperty("data")
    private OpenApiInfoDto openApiInfoDto;

    public OpenApiDataDto(OpenApiInfoDto openApiInfoDto) {
        this.openApiInfoDto = new OpenApiInfoDto(openApiInfoDto);
    }
}
