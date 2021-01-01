package com.example.inklow.configuration;

import com.example.inklow.dao.UserDao;
import com.example.inklow.security.Authentication;
import com.example.inklow.service.UserService;
import com.example.inklow.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserServiceConfig {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final Authentication authentication;

    @Autowired
    public UserServiceConfig(final Authentication authentication, final UserDao userDao, final PasswordEncoder passwordEncoder) {
        this.authentication = authentication;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean()
    @Primary
    public UserService userService() {
        return new UserServiceImp(authentication, userDao, passwordEncoder);
    }
}
