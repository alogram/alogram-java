package com.alogram.payrisk.exceptions;

public class AuthenticationException extends AlogramException {
    public AuthenticationException(String message, int statusCode, String responseBody) {
        super(message, statusCode, responseBody);
    }
}
