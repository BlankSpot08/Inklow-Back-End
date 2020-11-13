package com.example.inklow.service;

import com.example.inklow.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public List<User> getUsers();
    public User findUserById(UUID id);
    public User findByUsername(String username);
}
