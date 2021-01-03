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
@RequestMapping(value = "/api")
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody User user) {
        User registerUser = userService.handleAccountRegistration(user);

        if (registerUser == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Register Failed");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Registered Successfully");
    }
}
