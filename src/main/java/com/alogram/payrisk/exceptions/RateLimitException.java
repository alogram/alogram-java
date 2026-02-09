package com.alogram.payrisk.exceptions;

public class RateLimitException extends AlogramException {
    public RateLimitException(String message, int statusCode, String responseBody) {
        super(message, statusCode, responseBody);
    }
}
