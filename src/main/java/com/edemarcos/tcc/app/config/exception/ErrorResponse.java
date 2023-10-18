package com.edemarcos.tcc.app.config.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorResponse {
    private String message;
    private Integer statusCode;

    public ErrorResponse(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(Integer status) {
        this.statusCode = statusCode;
    }

    public String getLocalDateTime() {
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return data.format(formatter);
    }
}
