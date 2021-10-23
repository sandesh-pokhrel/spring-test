package com.sandesh.springtest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<?> handleCarNotFound(CarNotFoundException ex) {
        return new ResponseEntity<>("Car not found!", HttpStatus.NOT_FOUND);
    }
}
