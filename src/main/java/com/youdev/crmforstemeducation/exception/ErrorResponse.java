package com.youdev.crmforstemeducation.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
public class ErrorResponse {
    private String message;
    private String details;
    private HttpStatus status;
    private LocalDateTime timestamp;

    public ErrorResponse(String message, String details, HttpStatus status) {
        this.message = message;
        this.details = details;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}
