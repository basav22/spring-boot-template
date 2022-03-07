package com.eyeota.taiyaki.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {

    private String message;

    private String details;

    public ErrorDto(String message) {
        this.message = message;
    }

}
