package com.davis.mealplanner.exceptions;

import org.springframework.security.core.AuthenticationException;

public class UnauthorizedAuthenticationException extends AuthenticationException{

    private static final String MESSAGE = "Unauthorized";

    public UnauthorizedAuthenticationException() {
        super(MESSAGE);
    }
    
    public UnauthorizedAuthenticationException(String msg) {
        super(msg);
    }
    
}
