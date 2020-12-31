package com.example.inklow.controller;

import com.example.inklow.dao.UserDao;
import com.example.inklow.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@PreAuthorize("hasAnyAuthority(Admin)")
public class AdminController {
    private final UserDao userDao;

    @Autowired
    public AdminController(final UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/api/adminGetUsers", method = RequestMethod.GET)
    public ResponseEntity<?> getUsersAdminWay() {
        List<User> getUsers = userDao.getListOfUsers();

        return ResponseEntity.status(HttpStatus.OK).body(getUsers);
    }
}
