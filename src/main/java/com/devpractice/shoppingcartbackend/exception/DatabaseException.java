package com.devpractice.shoppingcartbackend.exception;

import com.devpractice.shoppingcartbackend.utils.ErrorCodes;

public class DatabaseException extends BusinessException {
    public DatabaseException(String message) {
        super(message, ErrorCodes.DATABASE_ERROR);
    }
}
