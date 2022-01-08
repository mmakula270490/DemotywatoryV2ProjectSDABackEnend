package com.example.demotywatoryv2.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotExistException extends ResponseStatusException {
    public UserNotExistException() {
        super(HttpStatus.NOT_FOUND, "User with such Id does not exist");
    }
}
