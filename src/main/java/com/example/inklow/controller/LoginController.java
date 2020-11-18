package com.example.inklow.controller;

import com.example.inklow.dao.UserDao;
import com.example.inklow.entities.User;
import com.example.inklow.model.AuthenticationRequest;
import com.example.inklow.model.AuthenticationResponse;
import com.example.inklow.security.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class LoginController {
    @Autowired
    private Authentication authentication;

    @PreAuthorize("")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> doLogin(@RequestBody AuthenticationRequest authenticationRequest) {
        String jwt = authentication.authenticate(authenticationRequest);

        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("lol no");
        }

        return ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponse(jwt));
    }

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User testGetUser() {
        return userDao.findUserById(UUID.fromString("cee3a79a-5192-4b8d-9fec-00d44c1aaed9"));
    }
}
