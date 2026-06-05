package com.codewithnolan.chatchitflutter.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleEntityNotFoundException(EntityNotFoundException ex) {
        ApiError apiError = new ApiError
                .Builder()
                .withMessage(ex.getMessage())
                .withHttpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(apiError, HttpStatusCode.valueOf(apiError.getStatusCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex) {
        String errorDetails = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        ApiError apiError = new ApiError
                .Builder()
                .withMessage(errorDetails)
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(apiError, HttpStatusCode.valueOf(apiError.getStatusCode()));
    }
}
