package com.example.demotywatoryv2.services.converters.get;

import com.example.demotywatoryv2.model.dao.entity.AuthoritiesEntity;
import com.example.demotywatoryv2.model.dao.entity.UserEntity;
import com.example.demotywatoryv2.model.dao.get.GetUserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertUsersDetails {

    public List<GetUserDetails> getDetails(List<UserEntity> users ) {
        List<GetUserDetails> usersDetails = new ArrayList<>();

        for (UserEntity user : users) {

            GetUserDetails userDetails = new GetUserDetails();

            userDetails.setUsername(user.getUsername());
            userDetails.setEmail(user.getEmail());

            for (AuthoritiesEntity authority : user.getAuthorities()) {
                userDetails.addToAuthorities(authority.getName());
            }
            usersDetails.add(userDetails);
        }

    return usersDetails;
    }
}