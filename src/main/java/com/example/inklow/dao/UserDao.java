package com.example.inklow.dao;

import com.example.inklow.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    List<User> getListOfUsers();
    User findUserById(UUID id);
    User findUserByUsername(String username);


    User addUser(User user);
    User removeUser(User user);

    Boolean removeAllUser();
}
