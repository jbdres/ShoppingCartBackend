package com.devpractice.shoppingcartbackend.exception;

import com.devpractice.shoppingcartbackend.utils.ErrorCodes;

public class InvalidDataException extends BusinessException {
    public InvalidDataException(String message) {
        super(message, ErrorCodes.INVALID_DATA);
    }
}
