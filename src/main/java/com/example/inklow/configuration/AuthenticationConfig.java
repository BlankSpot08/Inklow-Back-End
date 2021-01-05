package com.example.inklow.configuration;

import com.example.inklow.security.Authentication;
import com.example.inklow.security.MyUserDetailService;
import com.example.inklow.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class AuthenticationConfig {
    private final MyUserDetailService myUserDetailService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    // I put the @Lazy to stop THE CIRCULAR DEPENDENCY
    @Autowired
    public AuthenticationConfig(final @Lazy MyUserDetailService myUserDetailService, final JwtUtil jwtUtil, final @Lazy AuthenticationManager authenticationManager) {
        this.myUserDetailService = myUserDetailService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }
/**
 * @return
 */
    @Bean
    @Primary
    public Authentication authentication() {
        return new Authentication(myUserDetailService, jwtUtil, authenticationManager);
    }
}
