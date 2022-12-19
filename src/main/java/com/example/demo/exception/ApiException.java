package com.example.demo.exception;
//This is a Normal Object Class for Api Exception.

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

//@Data It is super annotation as set public constructor, getters, setters & toString functions.
@Data
public class ApiException {
    private final String message;
    //@JsonIgnore
    private final Throwable throwable;
    private  final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;

//    public ApiException(String message,
//                        Throwable throwable,
//                        HttpStatus httpStatus,
//                        ZonedDateTime zonedDateTime) {
//        this.message = message;
//        this.throwable = throwable;
//        this.httpStatus = httpStatus;
//        this.zonedDateTime = zonedDateTime;
//    }
//
//    public HttpStatus getHttpStatus() {
//        return httpStatus;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public Throwable getThrowable() {
//        return throwable;
//    }
//
//    public ZonedDateTime getZonedDateTime() {
//        return zonedDateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "ApiException{" +
//                "message='" + message + '\'' +
//                ", throwable=" + throwable +
//                ", httpStatus=" + httpStatus +
//                ", zonedDateTime=" + zonedDateTime +
//                '}';
//    }
}
