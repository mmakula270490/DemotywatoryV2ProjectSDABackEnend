package com.example.demotywatoryv2.model.dao.get;

import java.util.List;

public class GetUsersResponse {

    private List<GetUserDetails> users;

    public GetUsersResponse(List<GetUserDetails> userDetailsList) {
        this.users = userDetailsList;
    }

    public List<GetUserDetails> getUsers() {
        return users;
    }

    public void setUsers(List<GetUserDetails> userDetailsList) {
        this.users = userDetailsList;
    }
}