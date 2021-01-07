package com.example.inklow.controller;

import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;
import com.example.inklow.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
    private final PermissionService permissionService;
    private final RolePermissionService rolePermissionService;
    private final UserRoleService userRoleService;

    @Autowired
    public AdminController(final UserService userService,
                           final RoleService roleService,
                           final PermissionService permissionService,
                           final RolePermissionService rolePermissionService,
                           final UserRoleService userRoleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.rolePermissionService = rolePermissionService;
        this.userRoleService = userRoleService;
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public ResponseEntity<?> getUsersAdminWay() {
        List<User> listOfUsers = userService.getListOfUsers();

        return ResponseEntity.status(HttpStatus.OK).body(listOfUsers);
    }

    @RequestMapping(value = "/getRoles", method = RequestMethod.GET)
    public ResponseEntity<?> getRolesAdminWay() {
        List<Role> listOfRoles = roleService.getListOfRoles();

        return ResponseEntity.status(HttpStatus.OK).body(listOfRoles);
    }
}

