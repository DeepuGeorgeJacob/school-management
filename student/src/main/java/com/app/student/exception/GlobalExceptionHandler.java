package com.app.student.exception;

import com.app.student.model.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
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
        final ApiResponse<Object> dataNotFoundResponse = new ApiResponse<>(dataNotFoundException.getExceptionMessage(), null);
        return new ResponseEntity<>(dataNotFoundResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralError(final Exception exception) {
        //exception.printStackTrace();
        final ApiResponse<Object> generalError = new ApiResponse<>("Unknown Error", null);
        return new ResponseEntity<>(generalError,HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleUnknownUrlException() {
        final ApiResponse<Object> generalError = new ApiResponse<>("Url not found", null);
        return new ResponseEntity<>(generalError, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final ApiResponse<Object> generalError = new ApiResponse<>("Url not found", null);
        return new ResponseEntity<>(generalError, HttpStatus.NOT_FOUND);
    }

}
