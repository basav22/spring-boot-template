package com.eyeota.taiyaki.handler;

import com.eyeota.taiyaki.model.dto.ErrorDto;
import com.eyeota.taiyaki.exception.BusinessException;
import com.eyeota.taiyaki.exception.TechnicalException;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@CommonsLog
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDto>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ErrorDto> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorDto("Wrong value in the field: " + error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorDto>> handleBusinessException(BusinessException exception) {
        log.error("Business Exception: " + exception.getMessage(), exception);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonList(new ErrorDto(exception.getMessage())));
    }

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<List<ErrorDto>> handleTechnicalException(TechnicalException exception) {
        log.error("Technical Exception: " + exception.getMessage(), exception);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Collections.singletonList(new ErrorDto(exception.getMessage())));
    }
}

