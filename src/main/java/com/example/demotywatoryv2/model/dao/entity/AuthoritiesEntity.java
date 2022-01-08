package com.example.demotywatoryv2.model.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class AuthoritiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public AuthoritiesEntity() {
    }

    public AuthoritiesEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
