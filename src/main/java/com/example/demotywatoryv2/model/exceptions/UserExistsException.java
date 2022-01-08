package com.example.demotywatoryv2.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserExistsException extends ResponseStatusException {
    public UserExistsException() {
        super(HttpStatus.BAD_REQUEST, "User with such name or email already exists");
    }
}
