package com.example.demotywatoryv2.model.dao;

import org.springframework.http.HttpStatus;

public class DeleteUserResponse {

    private HttpStatus status;

    public DeleteUserResponse(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}
