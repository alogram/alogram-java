package com.alogram.payrisk.exceptions;

public class ScopedAccessException extends AlogramException {
    public ScopedAccessException(String message) {
        super(message, 403, null);
    }
}
