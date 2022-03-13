package com.app.student.exception;

public class DataNotFoundException extends RuntimeException {
    private final String exceptionMessage;
    public DataNotFoundException(final String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
