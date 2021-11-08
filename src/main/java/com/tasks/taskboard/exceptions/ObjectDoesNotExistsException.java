package com.tasks.taskboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObjectDoesNotExistsException extends RuntimeException {
    private String message;
    private Throwable cause;

    public ObjectDoesNotExistsException() {
    }

    public ObjectDoesNotExistsException(String message) {
        this.message = message;
    }

    public ObjectDoesNotExistsException(String message, Throwable cause) {
        this.message = message;
        this.cause = fillInStackTrace();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
