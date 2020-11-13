package com.example.inklow.dao;

import com.example.inklow.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
//    User addUser(User user);
//    User removeUser(User user);
//    User updateUser(User user);
    User findUserById(UUID id);
    User findUserByUsername(String username);

    List<User> getListOfUsers();

}
