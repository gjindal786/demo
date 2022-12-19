package com.example.demo.exception;
//This is a Normal Object Class for NotFound Exception to handle RuntimeException.
//We can make multiple classes to handle different types of RuntimeException.
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus : This allow us to change http status code for api.
//We have comment below line as we have implement NotFoundException in ApiExceptionHandler
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
