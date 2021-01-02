package com.example.inklow.security;

import com.example.inklow.entities.User;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {
    private final UserService userServiceImp;

    @Autowired
    public MyUserDetailService(UserService userService) {
        this.userServiceImp = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User tempUser = userServiceImp.findUserByUsername(username);

        return new MyUserDetail(tempUser);
    }
}