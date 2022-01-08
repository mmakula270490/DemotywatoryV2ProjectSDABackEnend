package com.example.demotywatoryv2.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CommentNotExistException extends ResponseStatusException {

    public CommentNotExistException() {
        super(HttpStatus.NOT_FOUND, "Comment with such Id does not exist.");
    }
}
