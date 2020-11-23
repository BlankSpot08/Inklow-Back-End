package com.example.inklow.dao;

import com.example.inklow.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    User findUserById(UUID id);
    User findUserByUsername(String username);
    List<User> getListOfUsers();

    User addUser(User user);

}
