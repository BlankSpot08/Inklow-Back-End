package com.example.inklow.controller;

import com.example.inklow.entities.User;
import com.example.inklow.model.AuthenticationRequest;
import com.example.inklow.model.AuthenticationResponse;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

//    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> doLogin(@RequestBody AuthenticationRequest authenticationRequest) {
        String jwt = userService.handleLogin(authenticationRequest);

        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access Denied");
        }

        return ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponse(jwt));
    }
}