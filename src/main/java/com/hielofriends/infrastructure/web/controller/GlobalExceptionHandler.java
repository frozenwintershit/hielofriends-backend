package com.hielofriends.infrastructure.web.controller;

import com.hielofriends.domain.exception.InvalidEmailException;
import com.hielofriends.domain.exception.OutOfStockException;
import com.hielofriends.infrastructure.web.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OutOfStockException.class)
    public ResponseEntity<ErrorResponse> handleOutOfStock(OutOfStockException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), "OUT_OF_STOCK", LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY); // 422
    }

    @ExceptionHandler({InvalidEmailException.class, IllegalArgumentException.class})
    public ResponseEntity<ErrorResponse> handleBadRequest(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), "INVALID_DATA", LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); // 400
    }
}