package com.example.demotywatoryv2.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PostNotExistException extends ResponseStatusException {

    public PostNotExistException() {
        super(HttpStatus.NOT_FOUND, "Demotywator with such Id does not exist.");
    }
}
