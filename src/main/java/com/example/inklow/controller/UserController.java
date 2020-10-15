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
            return ResponseEntity.status(HttpStatus.CREATED).body("Operation Post Successfully");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Operation Post Failed");
    }

    @RequestMapping(value = "users/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeUser(@PathVariable String username) {
        User tempUser = userDao.removeUser(username);

        if (tempUser != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Operation Delete Successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Operation Delete Failed");
    }

    @RequestMapping(value = "users/updateLastname/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<String> updateLastName(@PathVariable String id, @RequestBody String lastname) {
        String tempLastName = userDao.updateLastName(id, lastname);

        if (tempLastName != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Operation Update Successfully");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Operation Update Failed");
    }

    @RequestMapping(value = "users/updateUsername/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<String> updateUsername(@PathVariable String id, @RequestBody String username) {
        String tempUsername = userDao.updateUsername(id, username);

        if (tempUsername != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Operation Update Successfully");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Operation Update Failed");
    }

    @RequestMapping(value = "users/updatePassword/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<String> updatePassword(@PathVariable String id, @RequestBody String password) {
        String tempPassword = userDao.updatePassword(id, password);

        if (tempPassword != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Operation Update Successfully");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Operation Update Failed");
    }

    @RequestMapping(value = "users/updateEmail/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<String> updateEmail(@PathVariable String id, @RequestBody String email) {
        String tempEmail = userDao.updateEmail(id, email);

        if (tempEmail != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Operation Update Successfully");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Operation Update Failed");
    }

    @RequestMapping(value = "users/updatePhoneNumber/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<String> updatePhoneNumber(@PathVariable String id, @RequestBody String phoneNumber) {
        String tempPhoneNumber = userDao.updatePhoneNumber(id, phoneNumber);

        if (tempPhoneNumber != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Operation Update Successfully");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Operation Update Failed");
    }
}
