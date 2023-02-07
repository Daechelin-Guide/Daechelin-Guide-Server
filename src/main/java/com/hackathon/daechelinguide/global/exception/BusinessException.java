package com.hackathon.daechelinguide.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class BusinessException {
    private HttpStatus httpStatus;
    private String message;
}
