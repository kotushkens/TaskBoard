package com.tasks.taskboard.controllers;

import com.tasks.taskboard.exceptions.NotValidParametersException;
import com.tasks.taskboard.exceptions.ObjectDoesNotExistsException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotValidParametersException.class)
    protected ResponseEntity<String> handleRequestException(NotValidParametersException e) {
        return ResponseEntity.badRequest()
                .body(e.getMessage());

    }

    @ExceptionHandler(ObjectDoesNotExistsException.class)
    protected ResponseEntity<?> handleObjectDoesNotExistsException(ObjectDoesNotExistsException e){
        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<String> handleArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<String> handleNullPointerException(NullPointerException e) {
        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }

}
