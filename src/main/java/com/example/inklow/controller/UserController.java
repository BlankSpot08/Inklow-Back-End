package com.example.inklow.controller;

import com.example.inklow.dao.UserDao;
import com.example.inklow.database.Database;
import com.example.inklow.implementation.UserDaoImp;
import com.example.inklow.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final Database database;
    private final UserDao userDao;

    public UserController() {
        database = new Database();
        userDao = new UserDaoImp(database);
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> users() throws InterruptedException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userDao.getUsers());
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody User user) {
        User tempUser = userDao.addUser(user);

        if (tempUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("nice");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("sad");
    }

    @RequestMapping(value = "users", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeUser(@RequestBody User user) {
        User tempUser = userDao.removeUser(user);

        if (tempUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("nice");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("sad");
    }

    @RequestMapping(value = "users/{username}", method = RequestMethod.PATCH)
    public ResponseEntity<String> updateUser(@PathVariable String username, @RequestBody User user) {
        User tempUser = userDao.updateUser(username, user);

        if (tempUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("nice");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("sad");
    }
}
