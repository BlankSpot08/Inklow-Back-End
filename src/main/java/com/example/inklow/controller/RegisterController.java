package com.example.inklow.controller;

import com.example.inklow.entities.User;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/inklow")
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping(name = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody User user) {
        User registerUser = userService.handleRegister(user);

        if (registerUser == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Register Failed");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Registered Successfully");
    }
}
