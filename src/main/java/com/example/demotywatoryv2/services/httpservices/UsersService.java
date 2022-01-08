package com.example.demotywatoryv2.services.httpservices;

import com.example.demotywatoryv2.model.dao.entity.UserEntity;
import com.example.demotywatoryv2.model.dao.get.GetUsersResponse;
import com.example.demotywatoryv2.model.dao.post.CreateUserRequest;
import com.example.demotywatoryv2.model.dao.put.ChangePasswordRequest;
import com.example.demotywatoryv2.model.dto.RoleType;
import com.example.demotywatoryv2.model.exceptions.UserExistsException;
import com.example.demotywatoryv2.model.exceptions.UserNotExistException;
import com.example.demotywatoryv2.repository.AuthoritiesRepository;
import com.example.demotywatoryv2.repository.UsersRepository;
import com.example.demotywatoryv2.services.converters.get.ConvertUsersDetails;
import com.example.demotywatoryv2.services.converters.post.ConvertRequestToUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ConvertRequestToUser requestToUser;

    @Autowired
    private ConvertUsersDetails getUsersDetails;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    public void createUser(CreateUserRequest createUserRequest) {

        try {
            UserEntity newUser = requestToUser.convert(createUserRequest);
            newUser.setAuthorities(Collections.singletonList(authoritiesRepository.findByName(RoleType.USER.name())));
            usersRepository.save(newUser);
        } catch(Exception ex){
            throw new UserExistsException();
        }
    }

    public GetUsersResponse getAllUsers(){

        List<UserEntity> users = usersRepository.findAll();

        return new GetUsersResponse(getUsersDetails.getDetails(users));
    }

    public void activateUser(Long userId) {

        UserEntity user = usersRepository.findById(userId)
                .orElseThrow(()->
                        new UserNotExistException());
        user.setActive(true);
        usersRepository.save(user);
    }

    public void changeUserPassword(Long userId, ChangePasswordRequest changePasswordRequest){

        UserEntity user = usersRepository.findById(userId)
                .orElseThrow(()->
                        new UserNotExistException());
        user.setPassword(changePasswordRequest.getPassword());
        usersRepository.save(user);
    }

    public boolean verifyUserByName(String currentUserName, Long userId){
        UserEntity user = usersRepository.findByUsername(currentUserName)
                .orElseThrow(()->
                        new UserNotExistException());

        return user.getId() == userId | user.getAuthorities().get(0).getName() == RoleType.ADMIN.name();
    }

    public void deleteByUserById(Long userId){

        UserEntity user = usersRepository.findById(userId)
                .orElseThrow(()->
                        new UserNotExistException());

        user.removeAuthorities();
        user.setUsername("~Deleted~" + user.getUsername());
        user.setEmail("~Deleted~" + user.getEmail());
        user.setActive(false);
        usersRepository.save(user);
    }

    public UserEntity getUserIdByName(String currentUserName){

        return usersRepository.findByUsername(currentUserName)
                .orElseThrow(()->
                        new UserNotExistException());
    }
}