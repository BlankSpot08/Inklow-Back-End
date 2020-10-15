package com.example.inklow.dao;

import com.example.inklow.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User addUser(User user);
    User removeUser(String username);
    String updateLastName(String username, String user);
    String updateUsername(String username, String user);
    String updatePassword(String username, String user);
    String updateEmail(String username, String user);
    String updatePhoneNumber(String username, String user);
}
