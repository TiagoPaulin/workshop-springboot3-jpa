package com.tiagopaulin.curso.resources.exceptions;

import com.tiagopaulin.curso.services.exceptions.DataBaseException;
import com.tiagopaulin.curso.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandartError standartError = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(standartError);

    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandartError> resourceNotFound(DataBaseException e, HttpServletRequest request) {

        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandartError standartError = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(standartError);

    }

}
