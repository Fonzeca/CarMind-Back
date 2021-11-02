package com.mindia.carmind.utils.exception;

import com.mindia.carmind.utils.exception.custom.UserHubException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(UserHubException.class)
    public ResponseEntity<?> handleUserHubException(UserHubException ex, WebRequest request){
        ErrorDetails details = new ErrorDetails(ex.getMessage(), ex.getError());
        
        return new ResponseEntity(details, HttpStatus.valueOf(ex.getCode()));
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex, WebRequest request){
        ErrorDetails details = new ErrorDetails();

        return new ResponseEntity(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
