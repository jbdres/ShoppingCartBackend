package com.devpractice.shoppingcartbackend.config;

import com.devpractice.shoppingcartbackend.exception.BusinessException;
import com.devpractice.shoppingcartbackend.utils.ErrorCodes;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex, HttpServletRequest request) {
        String errorCode = ex.getErrorCode();
        String message = ex.getMessage();
        ErrorResponse errorResponse = createErrorResponse(errorCode, message, request.getRequestURI());
        HttpStatus httpStatus = determineHttpStatus(errorCode);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return errors;
    }

    private ErrorResponse createErrorResponse(String errorCode, String message, String path) {
        return new ErrorResponse(errorCode, message, LocalDateTime.now(), path);
    }

    private HttpStatus determineHttpStatus(String errorCode) {
        return switch (errorCode) {
            case ErrorCodes.RESOURCE_NOT_FOUND -> HttpStatus.NOT_FOUND;
            case ErrorCodes.INVALID_DATA -> HttpStatus.BAD_REQUEST;
            case ErrorCodes.RESOURCE_CONFLICT -> HttpStatus.CONFLICT;
            default -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
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
