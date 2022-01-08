package com.example.demotywatoryv2.configuration.security;

import com.example.demotywatoryv2.model.dao.entity.UserEntity;
import com.example.demotywatoryv2.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = usersRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(username));


        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .disabled(!user.isActive())
                .authorities(user.getAuthorities()
                        .stream()
                        .map(x -> x.getName())
                        .toArray(String[]::new))
                .build();

    }
}
