package com.example.inklow.controller;

import com.example.inklow.dao.UserDao;
import com.example.inklow.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
    @Autowired
    private UserDao userDaoImp;

    public UserController() { }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> users() throws InterruptedException {
        return ResponseEntity.status(HttpStatus.OK).body(userDaoImp.getUsers());
    }

    @RequestMapping(value = "users", method = RequestMethod.PUT)
    public ResponseEntity<String> addUser(@RequestBody User user) {
        User tempUser = userDaoImp.addUser(user);

        if (tempUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Operation Post Successfully");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Operation Post Failed");
    }

    @RequestMapping(value = "users", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeUser(@RequestBody User user) {
        User tempUser = userDaoImp.removeUser(user);

        if (tempUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Operation Delete Successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Operation Delete Failed");
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        User tempUser = userDaoImp.updateUser(user);

        if (tempUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Operation Update Successfully");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Operation Post Failed");
    }

//    @RequestMapping(value = "users/updateLastname/{id}", method = RequestMethod.PATCH)
//    public ResponseEntity<String> updateLastName(@PathVariable String id, @RequestBody String lastname) {
//        String tempLastName = userDaoImp.updateLastName(id, lastname);
//
//        if (tempLastName != null) {
//            return ResponseEntity.status(HttpStatus.OK).body("Operation Update Successfully");
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body("Operation Update Failed");
//    }
//
//    @RequestMapping(value = "users/updateUsername/{id}", method = RequestMethod.PATCH)
//    public ResponseEntity<String> updateUsername(@PathVariable String id, @RequestBody String username) {
//        String tempUsername = userDaoImp.updateUsername(id, username);
//
//        if (tempUsername != null) {
//            return ResponseEntity.status(HttpStatus.OK).body("Operation Update Successfully");
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body("Operation Update Failed");
//    }
//
//    @RequestMapping(value = "users/updatePassword/{id}", method = RequestMethod.PATCH)
//    public ResponseEntity<String> updatePassword(@PathVariable String id, @RequestBody String password) {
//        String tempPassword = userDaoImp.updatePassword(id, password);
//
//        if (tempPassword != null) {
//            return ResponseEntity.status(HttpStatus.OK).body("Operation Update Successfully");
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body("Operation Update Failed");
//    }
//
//    @RequestMapping(value = "users/updateEmail/{id}", method = RequestMethod.PATCH)
//    public ResponseEntity<String> updateEmail(@PathVariable String id, @RequestBody String email) {
//        String tempEmail = userDaoImp.updateEmail(id, email);
//
//        if (tempEmail != null) {
//            return ResponseEntity.status(HttpStatus.OK).body("Operation Update Successfully");
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body("Operation Update Failed");
//    }
//
//    @RequestMapping(value = "users/updatePhoneNumber/{id}", method = RequestMethod.PATCH)
//    public ResponseEntity<String> updatePhoneNumber(@PathVariable String id, @RequestBody String phoneNumber) {
//        String tempPhoneNumber = userDaoImp.updatePhoneNumber(id, phoneNumber);
//
//        if (tempPhoneNumber != null) {
//            return ResponseEntity.status(HttpStatus.OK).body("Operation Update Successfully");
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body("Operation Update Failed");
//    }
}
