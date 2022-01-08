package com.example.demotywatoryv2.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NullValueException extends ResponseStatusException {

    public NullValueException() {
        super(HttpStatus.BAD_REQUEST, "Value cannot be null");
    }
}
