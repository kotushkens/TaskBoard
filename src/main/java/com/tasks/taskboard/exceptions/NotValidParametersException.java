package com.tasks.taskboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotValidParametersException extends RuntimeException {
    private String message;
    private Throwable cause;

    public NotValidParametersException() {
    }

    public NotValidParametersException(String message) {
        this.message = message;
    }

    public NotValidParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
