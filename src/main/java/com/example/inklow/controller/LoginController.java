package com.example.inklow.controller;

import com.example.inklow.model.AuthenticationRequest;
import com.example.inklow.model.AuthenticationResponse;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final UserService userServiceImp;

    @Autowired
    public LoginController(UserService userService) {
        this.userServiceImp = userService;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api" + LoginController.LOGIN_ENDPOINTS.LOGIN, method = RequestMethod.POST)
    public ResponseEntity<?> handleLogin(@RequestBody @NonNull AuthenticationRequest authenticationRequest) {
        String jwt = userServiceImp.handleLogin(authenticationRequest);

        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access Denied");
        }

        return ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponse(jwt));
    }

    protected static final class LOGIN_ENDPOINTS {
        protected static final String LOGIN = "/user_authentication";
    }
}
