// dans /exception/ResourceAlreadyExistsException.java
package com.clean.auto.backend.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}