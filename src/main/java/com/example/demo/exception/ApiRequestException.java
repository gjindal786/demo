package com.example.demo.exception;
//This is a Normal Object Class for Api Request Exception to handle RuntimeException.
//We can make multiple classes to handle different types of RuntimeException.

public class ApiRequestException extends RuntimeException {
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message,cause);
    }
}
