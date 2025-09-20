package com.quote.exception;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;           // Request path where error occurred
    private String exception;      // Exception class name
    private String trace;          // Stack trace for debugging
}
