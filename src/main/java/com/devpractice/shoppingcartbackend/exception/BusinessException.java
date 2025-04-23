package com.devpractice.shoppingcartbackend.exception;

import lombok.Getter;

@Getter
public abstract class BusinessException extends RuntimeException {

    private final String errorCode;

    public BusinessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
