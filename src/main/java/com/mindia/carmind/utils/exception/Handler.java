package com.mindia.carmind.utils.exception;

import com.mindia.carmind.utils.exception.custom.UserHubException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(UserHubException.class)
    public ResponseEntity<?> handleUserHubException(UserHubException ex, WebRequest request){
        ErrorDetails details = new ErrorDetails(ex.getMessage(), ex.getError());
        
        return new ResponseEntity(details, HttpStatus.valueOf(ex.getCode()));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResponseStatusException(ResponseStatusException ex, WebRequest request){
        ErrorDetails details = new ErrorDetails(ex.getReason(), ex.getStatus().value()+"");
        
        return new ResponseEntity(details, ex.getStatus());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleResponseStatusException(AccessDeniedException ex, WebRequest request){
        ErrorDetails details = new ErrorDetails(ex.getMessage(), "");
        
        return new ResponseEntity(details, HttpStatus.FORBIDDEN);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex, WebRequest request){
        ErrorDetails details = new ErrorDetails();

        ex.printStackTrace();
        return new ResponseEntity(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
