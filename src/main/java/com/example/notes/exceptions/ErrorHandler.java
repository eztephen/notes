package com.example.notes.exceptions;

import com.example.notes.models.dtos.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<ApiError> handle(ConstraintViolationException ex) {
        String errorMessage = new ArrayList<>(ex.getConstraintViolations()).get(0).getMessage();
        return new ResponseEntity<ApiError>(new ApiError(400, errorMessage), null, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<ApiError> handle(NullPointerException ex) {
        return new ResponseEntity<ApiError>(new ApiError(404, ex.getMessage()), null, HttpStatus.NOT_FOUND);
    }
}
