package com.example.demo.exception;
//This is a Normal Object Class for Handling multiple ApiRequestExceptions.

import com.example.demo.customer.CustomerDbService;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

//@ControllerAdvice : We can put more than one Exceptions
@ControllerAdvice

@Slf4j
public class ApiExceptionHandler {

//    private final static Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);
    //@ExceptionHandler Write all Exceptions we want to handle
    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException apiRequestException) {
        ApiException apiPostException = new ApiException(apiRequestException.getMessage(),apiRequestException,HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return new ResponseEntity<>(apiPostException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(NotFoundException notFoundException) {
        ApiException apiPostException = new ApiException(notFoundException.getMessage(),notFoundException,HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(apiPostException, HttpStatus.NOT_FOUND);
    }
}
