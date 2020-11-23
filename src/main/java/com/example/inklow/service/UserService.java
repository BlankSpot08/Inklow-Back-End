package com.example.inklow.service;

import com.example.inklow.entities.User;
import com.example.inklow.model.AuthenticationRequest;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public List<User> getUsers();
    public User findUserById(UUID id);
    public User findByUsername(String username);

    public String handleLogin(AuthenticationRequest authenticationRequest);
    public User handleRegister(User user);
}
