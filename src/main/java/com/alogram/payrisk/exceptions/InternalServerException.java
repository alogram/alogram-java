package com.alogram.payrisk.exceptions;

public class InternalServerException extends AlogramException {
    public InternalServerException(String message, int statusCode, String responseBody) {
        super(message, statusCode, responseBody);
    }
}
