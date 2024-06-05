package com.aug.helpdesk.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aug.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.aug.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandle {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex,
            HttpServletRequest resquest) {
        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(), "Object Not Found", ex.getMessage(), resquest.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException ex,
            HttpServletRequest resquest) {
        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), "Violação de Dados", ex.getMessage(), resquest.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException ex,
            HttpServletRequest resquest) {
        ValidationError errors = new ValidationError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), "Validation Error", "Error na validação dos campos",
                resquest.getRequestURI());

        for (FieldError fe : ex.getBindingResult().getFieldErrors()) {
            errors.setErros(fe.getField(), fe.getDefaultMessage());
        }
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
