package com.example.demotywatoryv2.services.converters.post;

import com.example.demotywatoryv2.model.dao.entity.UserEntity;
import com.example.demotywatoryv2.model.dao.post.CreateUserRequest;
import org.springframework.stereotype.Component;

@Component
public class ConvertRequestToUser {

    public UserEntity convert(CreateUserRequest createUserRequest) {

        UserEntity user = new UserEntity();

        user.setUsername(createUserRequest.getUsername());
        user.setPassword(createUserRequest.getPassword());
        user.setEmail(createUserRequest.getEmail());
        return user;
    }
}