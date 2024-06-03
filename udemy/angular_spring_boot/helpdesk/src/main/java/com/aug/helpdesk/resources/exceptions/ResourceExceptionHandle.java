package com.aug.helpdesk.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aug.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandle {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest resquest) {
        StandardError error = new StandardError(System.currentTimeMillis(), 
        HttpStatus.NOT_FOUND.value(),"Object Not Found", ex.getMessage(), resquest.getRequestURI());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
