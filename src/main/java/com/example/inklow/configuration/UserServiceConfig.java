package com.example.inklow.configuration;

import com.example.inklow.dao.UserDao;
import com.example.inklow.security.Authentication;
import com.example.inklow.service.UserService;
import com.example.inklow.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserServiceConfig {
    @Autowired
    private UserDao userDao;

    @Autowired
    private Authentication authentication;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public UserService userService() {
        return new UserServiceImp(authentication, userDao, passwordEncoder);
    }
}
