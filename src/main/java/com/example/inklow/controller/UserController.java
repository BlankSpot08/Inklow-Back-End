package com.example.inklow.controller;

import com.example.inklow.entities.User;
import com.example.inklow.security.util.JwtUtil;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api" + UserController.ENDPOINTS.USER)
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserController(final UserService userService, final JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PreAuthorize(value = "hasAuthority('CAN_VIEW_ALL_USER_PROFILE')")
    @RequestMapping(value = ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {
        List<User> listOfUsers = userService.getListOfUsers();

        return ResponseEntity.status(HttpStatus.OK).body(listOfUsers);
    }

    @PreAuthorize(value = "hasAnyAuthority(#ENDPOINTS.GET_PERMISSION)")
    @RequestMapping(value = ENDPOINTS.GET, method = RequestMethod.POST)
    public ResponseEntity<?> getUser(@RequestHeader(name = "Authorization") String authorizationHeader) {
        String jwt = authorizationHeader.split(" ")[1];

        User user = userService.findUserByUsername(jwtUtil.extractUsername(jwt));

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PreAuthorize(value = "hasAnyAuthority(#ENDPOINTS.UPDATE_PERMISSION)")
    @RequestMapping(value = ENDPOINTS.UPDATE, method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User tempUser = userService.findUserByUsername(user.getUsername());

        userService.handleAccountChanges(tempUser);

        return ResponseEntity.status(HttpStatus.OK).body(tempUser);
    }

    @PreAuthorize(value = "hasAnyAuthority(#ENDPOINTS.DELETE_PERMISSION)")
    @RequestMapping(value = ENDPOINTS.DELETE, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        User tempUser = userService.findUserByUsername(user.getUsername());

        userService.handleAccountDeletion(tempUser);

        return ResponseEntity.status(HttpStatus.OK).body(tempUser);
    }

    @Component
    public static class ENDPOINTS {
        protected static final String USER = "/user";

        public static final String GET = "/get";
        public static final String GET_PERMISSION = "CAN_VIEW_USER_PROFILE";

        public static final String GET_ALL = "/getAll";
        public static final String GET_ALL_PERMISSION = "CAN_VIEW_ALL_USER_PROFILE";

        public static final String UPDATE = "/update";
        public static final String UPDATE_PERMISSION = "CAN_UPDATE_USER_PROFILE";

        public static final String DELETE = "/delete";
        public static final String DELETE_PERMISSION = "CAN_DELETE_USER_PROFILE";
    }
}
