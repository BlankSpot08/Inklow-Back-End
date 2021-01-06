package com.example.inklow.controller;

import com.example.inklow.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HomeController {
    private final UserService userService;
    private final RoleService roleService;
    private final PermissionService permissionService;
    private final UserRoleService userRoleService;
    private final RolePermissionService rolePermissionService;

    @Autowired
    public HomeController(UserService userService,
                          RoleService roleService,
                          PermissionService permissionService,
                          UserRoleService userRoleService,
                          RolePermissionService rolePermissionService) {
        this.userService = userService;
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.userRoleService = userRoleService;
        this.rolePermissionService = rolePermissionService;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "getAllUsers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getListOfUsers());
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "getAllRoles", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRoles() {
        return ResponseEntity.status(HttpStatus.OK).body(roleService.getListOfRoles());
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "getAllPermissions", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPermissions() {
        return ResponseEntity.status(HttpStatus.OK).body(permissionService.getListOfPermission());
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "getAllRolePermissions", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRolePermissions() {
        return ResponseEntity.status(HttpStatus.OK).body(rolePermissionService.getListOfUserRoles());
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "getAllUserRoles", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUserRoles() {
        return ResponseEntity.status(HttpStatus.OK).body(userRoleService.getListOfUserRoles());
    }
}
