package com.mindia.carmind.utils.exception;

import javax.persistence.EntityNotFoundException;

import com.mindia.carmind.utils.exception.custom.EmptyFieldOnPojo;
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
        
        return new ResponseEntity<ErrorDetails>(details, HttpStatus.valueOf(ex.getCode()));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResponseStatusException(ResponseStatusException ex, WebRequest request){
        ErrorDetails details = new ErrorDetails(ex.getReason(), ex.getStatus().value()+"");
        
        return new ResponseEntity<ErrorDetails>(details, ex.getStatus());
    }

    @ExceptionHandler(EmptyFieldOnPojo.class)
    public ResponseEntity<?> handleEmptyFieldOnPojo(EmptyFieldOnPojo ex, WebRequest request){
        ErrorDetails details = new ErrorDetails(ex.getMessage(), HttpStatus.BAD_REQUEST.value()+"");
        
        return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleResponseStatusException(AccessDeniedException ex, WebRequest request){
        ErrorDetails details = new ErrorDetails(ex.getMessage(), "");
        
        return new ResponseEntity<ErrorDetails>(details, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleResponseStatusException(EntityNotFoundException ex, WebRequest request){
        ErrorDetails details = new ErrorDetails("Entidad no encontrada", ex.getMessage());
        
        return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex, WebRequest request){
        ErrorDetails details = new ErrorDetails();

        ex.printStackTrace();
        return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
