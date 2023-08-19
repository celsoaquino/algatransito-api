package com.celsoaquino.algatransito.api.exceptionhandler;

import com.celsoaquino.algatransito.domain.exception.NegocioException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<String> captura(NegocioException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
