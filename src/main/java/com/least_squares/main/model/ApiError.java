package com.least_squares.main.model;

import org.springframework.http.HttpStatus;

public class ApiError {
    public HttpStatus status;
    public String message;

    public ApiError(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
}
