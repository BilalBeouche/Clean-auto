// dans /exception/InvalidCredentialsException.java
package com.clean.auto.backend.exception;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message) {
        super(message);
    }
}