package com.tasks.taskboard.connection;

public class Response {
    private String error;
    private String status;

    public Response() {
    }

    public Response(String error) {
        this.error = error;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}

