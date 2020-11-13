package com.example.inklow.controller;

import com.example.inklow.dao.UserDao;
import com.example.inklow.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private UserDao userDaoImp;

    public UserController() { }


//    @RequestMapping(value = "users", method = RequestMethod.GET)
//    public ResponseEntity<List<User>> users() throws InterruptedException {
//        return ResponseEntity.status(HttpStatus.OK).body(userDaoImp.getListOfUsers());
//    }
//
//    @RequestMapping(value = "users", method = RequestMethod.PUT)
//    public ResponseEntity<String> addUser(@RequestBody User user) {
//        User tempUser = userDaoImp.addUser(user);
//
//        if (tempUser != null) {
//            return ResponseEntity.status(HttpStatus.CREATED).body("Operation Post Successfully");
//        }
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Operation Post Failed");
//    }
//
//    @RequestMapping(value = "users", method = RequestMethod.DELETE)
//    public ResponseEntity<String> removeUser(@RequestBody User user) {
//        User tempUser = userDaoImp.removeUser(user);
//
//        if (tempUser != null) {
//            return ResponseEntity.status(HttpStatus.OK).body("Operation Delete Successfully");
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Operation Delete Failed");
//    }
//
//    @RequestMapping(value = "users", method = RequestMethod.POST)
//    public ResponseEntity<String> updateUser(@RequestBody User user) {
//        User tempUser = userDaoImp.updateUser(user);
//
//        if (tempUser != null) {
//            return ResponseEntity.status(HttpStatus.OK).body("Operation Update Successfully");
//        }
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Operation Post Failed");
//    }
}
