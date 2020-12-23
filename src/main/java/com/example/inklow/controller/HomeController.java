package com.example.inklow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @PreAuthorize("permitAll()")
    @RequestMapping(value = "test", method = RequestMethod.POST)
    public ResponseEntity<?> home() {
        return ResponseEntity.status(HttpStatus.OK).body("nice");
    }
}
