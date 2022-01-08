package com.example.demotywatoryv2.model.dao.put;

import org.springframework.http.HttpStatus;

public class ChangePasswordResponse {

    private HttpStatus status;

    public ChangePasswordResponse(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
