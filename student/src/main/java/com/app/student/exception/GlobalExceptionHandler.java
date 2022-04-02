package com.app.student.exception;

import com.app.student.model.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleDataNotFoundException(final DataNotFoundException dataNotFoundException) {
        final ApiResponse<Object> dataNotFoundResponse = ApiResponse.builder().errorMessage(dataNotFoundException.getExceptionMessage()).build();
        return new ResponseEntity<>(dataNotFoundResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralError(final Exception exception) {
        exception.printStackTrace();
        final ApiResponse<Object> generalError = ApiResponse.builder().errorMessage("Unknown Error").build();
        return new ResponseEntity<>(generalError, HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleUnknownUrlException() {
        final ApiResponse<Object> generalError = ApiResponse.builder().errorMessage("Url not found").build();
        return new ResponseEntity<>(generalError, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final ApiResponse<Object> generalError = ApiResponse.builder().errorMessage("Url not found").build();
        return new ResponseEntity<>(generalError, HttpStatus.NOT_FOUND);
    }

}
