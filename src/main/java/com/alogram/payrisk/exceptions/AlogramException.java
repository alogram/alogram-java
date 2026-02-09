package com.alogram.payrisk.exceptions;

public class AlogramException extends RuntimeException {
    private final int statusCode;
    private final String responseBody;

    public AlogramException(String message, int statusCode, String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    @Override
    public String toString() {
        return String.format("%s (Status: %d): %s", getClass().getSimpleName(), statusCode, getMessage());
    }
}
