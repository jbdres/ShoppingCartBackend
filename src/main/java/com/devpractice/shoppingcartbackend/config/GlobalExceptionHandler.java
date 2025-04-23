package com.devpractice.shoppingcartbackend.config;

import com.devpractice.shoppingcartbackend.exception.BusinessException;
import com.devpractice.shoppingcartbackend.utils.ErrorCodes;
import jakarta.servlet.http.HttpServletRequest;
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

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex, HttpServletRequest request) {
        ErrorResponse errorResponse = createErrorResponse(
                ErrorCodes.UNEXPECTED_ERROR,
                "An unexpected error occurred: " + ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
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

}
