package com.nocountry.ecommerce.exception;

import org.springframework.security.core.AuthenticationException;

public class PasswordInvalidException extends AuthenticationException {
    public PasswordInvalidException(String reason) {
        super(reason);
    }
}
