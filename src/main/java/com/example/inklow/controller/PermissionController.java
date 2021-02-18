package com.example.inklow.controller;

import com.example.inklow.entities.Permission;
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
@PreAuthorize("isAuthenticated()")
@RequestMapping(value = "/api" + PermissionController.PERMISSION_ENDPOINTS.PERMISSION)
public class PermissionController {
    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PreAuthorize("hasAnyAuthority('CAN_VIEW_PERMISSION')")
    @RequestMapping(value = PERMISSION_ENDPOINTS.GET, method = RequestMethod.POST)
    public ResponseEntity<?> getPermission(@RequestBody Permission permission) {
        Permission tempPermission = permissionService.getPermissionByName(permission.getName());

        return ResponseEntity.status(HttpStatus.OK).body(tempPermission);
    }

    @PreAuthorize("hasAnyAuthority('CAN_VIEW_ALL_PERMISSION')")
    @RequestMapping(value = PERMISSION_ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllPermission() {
        List<Permission> listOfRole = permissionService.getListOfPermission();

        return ResponseEntity.status(HttpStatus.OK).body(listOfRole);
    }

    protected static final class PERMISSION_ENDPOINTS {
        protected static final String PERMISSION = "/permission";

        protected static final String GET = PERMISSION + "/get";

        protected static final String GET_ALL = PERMISSION + "/getAll";
    }
}
