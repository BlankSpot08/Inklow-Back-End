package com.example.inklow.serviceImp;

import com.example.inklow.dao.UserDao;
import com.example.inklow.entities.User;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

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
}
