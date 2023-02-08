package com.hackathon.daechelinguide.domain.menu.presentation.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OpenApiDataDto implements Serializable {
    @JsonProperty("data")
    private OpenApiInfoDto openApiInfoDto;

    public OpenApiDataDto regeneration() {
        this.openApiInfoDto = new OpenApiInfoDto(openApiInfoDto);
        return this;
    }
}
