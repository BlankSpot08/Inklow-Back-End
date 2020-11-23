package com.example.inklow.controller;

import com.example.inklow.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@PreAuthorize("permitAll()")
public class UserController {
    @Autowired
    private UserDao userDaoImp;

    public UserController() {  }
}
