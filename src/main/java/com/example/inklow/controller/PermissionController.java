package com.example.inklow.controller;

import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.service.PermissionService;
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
@RequestMapping("")
public class PermissionController {
    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PreAuthorize("hasAnyAuthority('{URL.PERMISSION.GET_PERMISSION_PERMISSION}')")
    @RequestMapping(value = "{URL.PERMISSION.GET_PERMISSION}", method = RequestMethod.POST)
    public ResponseEntity<?> getPermission(@RequestBody Permission permission) {
        Permission tempPermission = permissionService.getPermissionByName(permission.getName());

        return ResponseEntity.status(HttpStatus.OK).body(tempPermission);
    }

    @PreAuthorize("hasAnyAuthority('{URL.PERMISSION.GET_ALL_PERMISSION_PERMISSION}')")
    @RequestMapping(value = "{URL.GET_ALL_PERMISSION}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPermission() {
        List<Permission> listOfRole = permissionService.getListOfPermission();

        return ResponseEntity.status(HttpStatus.OK).body(listOfRole);
    }
}
