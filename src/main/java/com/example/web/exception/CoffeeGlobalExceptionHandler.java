package com.example.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CoffeeGlobalExceptionHandler {

    @ExceptionHandler(value = {NoCoffeeBeansException.class})
    public ResponseEntity<ExceptionMessage> noCoffeeBeansException(NoCoffeeBeansException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(e.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.OK);
    }

    @ExceptionHandler(value = {NoWaterException.class})
    public ResponseEntity<ExceptionMessage> noWaterException(NoWaterException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(e.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.OK);
    }

    @ExceptionHandler(value = {NoMilkException.class})
    public ResponseEntity<ExceptionMessage> noMilkException(NoMilkException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(e.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.OK);
    }

    @ExceptionHandler(value = {NoDateException.class})
    public ResponseEntity<ExceptionMessage> noDateException(NoDateException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(e.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.OK);
    }
}
