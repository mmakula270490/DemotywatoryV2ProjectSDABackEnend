package com.example.demotywatoryv2.repository;

import com.example.demotywatoryv2.model.dao.entity.AuthoritiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository  extends JpaRepository<AuthoritiesEntity, Long> {

    AuthoritiesEntity findByName(String name);
}
