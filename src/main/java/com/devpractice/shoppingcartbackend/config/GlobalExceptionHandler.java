package com.devpractice.shoppingcartbackend.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class GlobalExceptionHandler {

    @Data
    @AllArgsConstructor
    static class ErrorResponse {
        private String errorCode;
        private String message;
        private LocalDateTime timestamp;
        private String path;
    }

}
