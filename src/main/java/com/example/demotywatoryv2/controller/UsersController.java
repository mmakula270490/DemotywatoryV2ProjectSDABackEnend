package com.example.demotywatoryv2.controller;

import com.example.demotywatoryv2.model.dao.post.CreateUserRequest;
import com.example.demotywatoryv2.services.httpservices.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping(path = "/api/users")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public void createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {

        usersService.createUser(createUserRequest);
    }

    @PutMapping(path = "api/users/{userId}/activate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activateUser(@PathVariable(name= "userId") Long userId) {

        usersService.activateUser(userId);
    }
}
