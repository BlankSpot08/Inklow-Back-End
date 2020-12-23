package com.example.inklow.service;

import com.example.inklow.entities.User;
import com.example.inklow.model.AuthenticationRequest;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getListOfUsers();
    User findUserById(UUID id);
    User findUserByUsername(String username);

    String handleLogin(AuthenticationRequest authenticationRequest);
    User handleRegister(User user);
}
