package com.example.inklow.security;

import com.example.inklow.model.AuthenticationRequest;

import com.example.inklow.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class Authentication {
    private final MyUserDetailService myUserDetailService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public Authentication(final MyUserDetailService myUserDetailService, final JwtUtil jwtUtil, final AuthenticationManager authenticationManager) {
        this.myUserDetailService = myUserDetailService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    public String authenticate(final AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return null;
        }

        final UserDetails user = myUserDetailService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(user);

        return jwt;
    }
}
