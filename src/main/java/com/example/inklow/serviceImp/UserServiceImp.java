package com.example.inklow.serviceImp;

import com.example.inklow.dao.UserDao;
import com.example.inklow.entities.User;
import com.example.inklow.model.AuthenticationRequest;
import com.example.inklow.security.Authentication;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public class UserServiceImp implements UserService {
    @Autowired
    private Authentication authentication;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImp() { }

    @Override
    public List<User> getUsers() {
        return userDao.getListOfUsers();
    }

    @Override
    public User findUserById(UUID id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public String handleLogin(AuthenticationRequest authenticationRequest) {
        String jwt = authentication.authenticate(authenticationRequest);

        return jwt;
    }

    @Override
    public User handleRegister(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User tempUser = userDao.addUser(user);

        return tempUser;
    }
}
