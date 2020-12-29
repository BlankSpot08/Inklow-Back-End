package com.example.inklow.configuration;

import com.example.inklow.security.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JwtUtilConfig {
    @Bean
    @Primary
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }
}
