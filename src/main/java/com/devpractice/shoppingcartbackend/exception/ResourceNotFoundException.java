package com.devpractice.shoppingcartbackend.exception;

import com.devpractice.shoppingcartbackend.utils.ErrorCodes;

public class ResourceNotFoundException extends BusinessException {
    public ResourceNotFoundException(String message) {
        super(message, ErrorCodes.RESOURCE_NOT_FOUND);
    }
}
