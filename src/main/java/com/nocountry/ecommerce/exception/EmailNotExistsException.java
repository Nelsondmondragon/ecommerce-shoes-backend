package com.nocountry.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

public class EmailNotExistsException extends AuthenticationException {
    public EmailNotExistsException(String message) {
        super(message);
    }
}
