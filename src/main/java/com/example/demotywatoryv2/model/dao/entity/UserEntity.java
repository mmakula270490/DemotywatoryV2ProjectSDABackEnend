package com.example.demotywatoryv2.model.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password")
    @Size(min = 2, max = 20)
    private String password;

    @Column(name = "active")
    private boolean active = false;

    @Column(name = "email", unique=true)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    List<AuthoritiesEntity> authorities;

    @OneToMany(mappedBy = "user")
    private Set<CommentsEntity> comments;

    public UserEntity() {
    }

    public UserEntity(String username, String password, boolean active, String email, List<AuthoritiesEntity> authorities) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.email = email;
        this.authorities = authorities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<AuthoritiesEntity> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthoritiesEntity> authorities) {
        this.authorities = authorities;
    }

    public void removeAuthorities(){
        this.authorities.clear();
    }

}
