package com.example.inklow.controller;

import com.example.inklow.entities.Role;
import com.example.inklow.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PreAuthorize("hasAnyAuthority('{URL.ADD_ROLE_PERMISSIOn}')")
    @RequestMapping(value = "{URL.ADD_ROLE}", method = RequestMethod.GET)
    public ResponseEntity<?> addRole() {
        List<Role> listOfRole = roleService.getListOfRoles();

        return ResponseEntity.status(HttpStatus.OK).body(listOfRole);
    }

    @PreAuthorize("hasAnyAuthority('{URL.GET_ROLE_PERMISSION}')")
    @RequestMapping(value = "{URL.GET_ROLE}", method = RequestMethod.POST)
    public ResponseEntity<?> getRoles(@RequestBody Role role) {
        Role tempRole = roleService.getRoleByName(role.getName());

        return ResponseEntity.status(HttpStatus.OK).body(tempRole);
    }

    @PreAuthorize("hasAnyAuthority('{URL.GET_ALL_ROLE_PERMISSION}')")
    @RequestMapping(value = "{URL.GET_ALL_ROLE}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRoles() {
        List<Role> listOfRole = roleService.getListOfRoles();

        return ResponseEntity.status(HttpStatus.OK).body(listOfRole);
    }

    @PreAuthorize("hasAnyAuthority('{URL.DELETE_ROLE_PERMISSION}')")
    @RequestMapping(value = "{URL.DELETE_ROLE}", method = RequestMethod.POST)
    public ResponseEntity<?> deleteRole(@RequestBody Role role) {
        Role tempRole = roleService.handleRoleDeletion(role);

        return ResponseEntity.status(HttpStatus.OK).body(tempRole);
    }
}
