package com.devpractice.shoppingcartbackend.config;

import com.devpractice.shoppingcartbackend.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class GlobalExceptionHandler {

    private ErrorResponse createErrorResponse(String errorCode, String message, String path) {
        return new ErrorResponse(errorCode, message, LocalDateTime.now(), path);
    }

    @Data
    @AllArgsConstructor
    static class ErrorResponse {
        private String errorCode;
        private String message;
        private LocalDateTime timestamp;
        private String path;
    }

}
