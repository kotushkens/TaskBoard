package com.tasks.taskboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_MODIFIED)
public class RequestException extends RuntimeException{
    private String message;
    private static final long serialVersionUID = -7806029002430564887L;

    public RequestException(){

    }

    public RequestException(String message) {
    this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
