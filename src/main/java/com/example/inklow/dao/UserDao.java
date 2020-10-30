package com.example.inklow.dao;

import com.example.inklow.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User addUser(User user);
    User removeUser(User user);
    User updateUser(User user);
}
