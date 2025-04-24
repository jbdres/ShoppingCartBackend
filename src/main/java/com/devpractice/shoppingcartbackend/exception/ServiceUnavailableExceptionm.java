package com.devpractice.shoppingcartbackend.exception;

import com.devpractice.shoppingcartbackend.utils.ErrorCodes;

public class ServiceUnavailableExceptionm extends BusinessException{
    public ServiceUnavailableExceptionm(String message) {
        super(message, ErrorCodes.SERVICE_UNAVAILABLE);
    }
}
