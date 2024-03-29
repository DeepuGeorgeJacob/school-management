package com.school.management.common.exception.handler;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataPresentException extends RuntimeException {
    private final String exceptionMessage;
    public DataPresentException(final String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
