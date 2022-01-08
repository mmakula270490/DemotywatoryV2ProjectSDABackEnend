package com.example.demotywatoryv2.configuration.security;


import com.example.demotywatoryv2.model.dto.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/h2-console/**").hasAuthority(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.POST,"/api/users").permitAll()
                .antMatchers(HttpMethod.GET,"/api/users").hasAuthority(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.POST,"/api/posts/{^[\\d]$}/comments").hasAnyAuthority(RoleType.ADMIN.name(), RoleType.USER.name())
                .antMatchers(HttpMethod.POST,"/api/posts/{^[\\d]$}/reactions/*").hasAuthority(RoleType.USER.name())
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .headers().frameOptions().disable();
    }
}