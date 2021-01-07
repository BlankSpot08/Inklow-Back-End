package com.example.inklow.controller;

import com.example.inklow.entities.Role;
import com.example.inklow.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/role")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(final RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "/getRoles", method = RequestMethod.GET)
    public ResponseEntity<?> getRoles() {
        List<Role> listOfRole = roleService.getListOfRoles();

        return ResponseEntity.status(HttpStatus.OK).body(listOfRole);
    }
}
