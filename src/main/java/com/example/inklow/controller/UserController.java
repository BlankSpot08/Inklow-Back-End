package com.example.inklow.controller;

import com.example.inklow.entities.User;
import com.example.inklow.security.util.JwtUtil;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserController(final UserService userService, final JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PreAuthorize("hasAnyAuthority('CAN_VIEW_USER')")
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public ResponseEntity<?> getUser(@RequestHeader(name = "Authorization") String authorizationHeader) {
        String jwt = authorizationHeader.split(" ")[1];

        User user = userService.findUserByUsername(jwtUtil.extractUsername(jwt));

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PreAuthorize("hasAnyAuthority('CAN_EDIT_USER')")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User tempUser = userService.findUserByUsername(user.getUsername());

        userService.handleAccountChanges(tempUser);

        return ResponseEntity.status(HttpStatus.OK).body(tempUser);
    }

    @PreAuthorize("hasAnyAuthority('CAN_DELETE_USER')")
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        User tempUser = userService.findUserByUsername(user.getUsername());

        userService.handleAccountDeletion(tempUser);

        return ResponseEntity.status(HttpStatus.OK).body(tempUser);
    }
}
