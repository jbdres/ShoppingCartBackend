package com.devpractice.shoppingcartbackend.exception;

import com.devpractice.shoppingcartbackend.utils.ErrorCodes;

public class ResourceConflictException extends BusinessException {
    public ResourceConflictException(String message) {
        super(message, ErrorCodes.RESOURCE_CONFLICT);
    }
}
