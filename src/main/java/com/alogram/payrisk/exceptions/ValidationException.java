package com.alogram.payrisk.exceptions;

public class ValidationException extends AlogramException {
    public ValidationException(String message, int statusCode, String responseBody) {
        super(message, statusCode, responseBody);
    }
}
