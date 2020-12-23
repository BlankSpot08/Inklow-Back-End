package com.example.inklow.controller;

import com.example.inklow.dao.UserDao;
import com.example.inklow.entities.User;
import com.example.inklow.security.util.JwtUtil;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    public UserController() {  }

    @PreAuthorize("hasAuthority('user')")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> getUser(@RequestHeader(name = "Authorization") String authorizationHeader) {
        String jwt = authorizationHeader.split(" ")[1];

        User user = userService.findUserByUsername(jwtUtil.extractUsername(jwt));

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PreAuthorize("hasAnyRole('admin')")
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ResponseEntity<?> testAdmin() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getListOfUsers());
    }

//    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getListOfUsers());
    }

    @RequestMapping(value = "getUserById", method = RequestMethod.POST)
    public ResponseEntity<?> getUserById() {
        UUID id = UUID.randomUUID();
        User user = userService.findUserById(id);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
