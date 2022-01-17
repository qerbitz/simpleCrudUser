package com.example.userpostman.entity;

import lombok.Data;
import org.springframework.http.HttpStatus;



@Data
public class HttpResponse {
    private int httpStatusCode; // 200, 201, 400, 500
    private HttpStatus httpStatus;
    private String message;

    public HttpResponse(int httpStatusCode, HttpStatus httpStatus, String message) {
        this.httpStatusCode = httpStatusCode;
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
