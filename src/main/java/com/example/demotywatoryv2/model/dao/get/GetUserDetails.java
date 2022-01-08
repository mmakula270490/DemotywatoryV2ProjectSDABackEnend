package com.example.demotywatoryv2.model.dao.get;

import java.util.ArrayList;
import java.util.List;

public class GetUserDetails {

    private String username;
    private String email;
    private List<String> authorities = new ArrayList<>();

    public GetUserDetails() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addToAuthorities(String authority){

        this.authorities.add(authority);

    }
    public List<String> getAuthorities() {
        return authorities;
    }
}
