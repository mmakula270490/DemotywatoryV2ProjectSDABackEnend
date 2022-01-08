package com.example.demotywatoryv2.configuration;

import com.example.demotywatoryv2.model.dao.entity.AuthoritiesEntity;
import com.example.demotywatoryv2.model.dao.entity.UserEntity;
import com.example.demotywatoryv2.model.dto.RoleType;
import com.example.demotywatoryv2.repository.AuthoritiesRepository;
import com.example.demotywatoryv2.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collections;

@Component
@Transactional
public class DataProvider implements CommandLineRunner {

    @Value("${api.authorization.admin.password}")
    private String adminPassword;

    @Value("${api.authorization.admin.username}")
    private String userNameAdmin;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Override
    public void run(String... args) throws Exception {

        AuthoritiesEntity roleAdmin = authoritiesRepository.save(new AuthoritiesEntity(RoleType.ADMIN.name()));

        authoritiesRepository.save(new AuthoritiesEntity(RoleType.USER.name()));
        usersRepository.save(new UserEntity(
                userNameAdmin,
                passwordEncoder.encode(adminPassword),
                true,
                null,
                Collections.singletonList(roleAdmin)
                ));
    }
}
