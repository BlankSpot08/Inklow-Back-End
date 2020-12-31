package com.example.inklow.configuration;

import com.example.inklow.security.MyUserDetailService;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyUserDetailServiceConfig {
    private final UserService userService;

    @Autowired
    public MyUserDetailServiceConfig(final UserService userService) {
        this.userService = userService;
    }

    @Bean
    @Primary
    public MyUserDetailService myUserDetailService() {
        return new MyUserDetailService(userService);
    }
}
