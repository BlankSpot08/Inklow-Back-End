package com.example.inklow.security;

import com.example.inklow.entities.User;
import com.example.inklow.service.UserService;
import com.example.inklow.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userServiceImp;

    public MyUserDetailService() { }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userServiceImp.findByUsername(username);

        return new MyUserDetail(user);
    }
}