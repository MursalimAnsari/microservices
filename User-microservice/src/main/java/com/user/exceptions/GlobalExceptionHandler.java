package com.user.exceptions;

import com.user.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
        String errorMessage = exception.getMessage();
        ApiResponse response =
              ApiResponse.builder()
              .message(errorMessage)
              .success(false)
              .status(HttpStatus.NOT_FOUND)
              .build();
     return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }
}
