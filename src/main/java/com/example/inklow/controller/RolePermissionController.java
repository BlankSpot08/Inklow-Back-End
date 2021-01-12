package com.example.inklow.controller;

import com.example.inklow.entities.Permission;
import com.example.inklow.entities.RolePermission;
import com.example.inklow.service.RolePermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api" + RolePermissionController.ROLE_PERMISSION_ENDPOINTS.ROLE_PERMISSION)
public class RolePermissionController {
    public final RolePermissionService rolePermissionService;

    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PreAuthorize("hasAuthority('CAN_CREATE_ROLE_PERMISSION')")
    @RequestMapping(value = ROLE_PERMISSION_ENDPOINTS.ADD, method = RequestMethod.POST)
    public ResponseEntity<?> addRolePermission(@RequestBody RolePermission rolePermission) {
        RolePermission tempRolePermission = rolePermissionService.handleRolePermissionRegistration(rolePermission);

        if (tempRolePermission == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(tempRolePermission);
        }

        return ResponseEntity.status(HttpStatus.OK).body(rolePermission);
    }

    @PreAuthorize("hasAuthority('CAN_VIEW_ALL_ROLE_PERMISSION')")
    @RequestMapping(value = ROLE_PERMISSION_ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllRolePermissions() {
        List<RolePermission> rolePermissions = rolePermissionService.getListOfUserRoles();

        return ResponseEntity.status(HttpStatus.OK).body(rolePermissions);
    }

    @PreAuthorize("hasAuthority('CAN_VIEW_ROLE_PERMISSION')")
    @RequestMapping(value = ROLE_PERMISSION_ENDPOINTS.GET, method = RequestMethod.POST)
    public ResponseEntity<?> getAllRolePermissions(@RequestBody RolePermission rolePermission) {
        List<Permission> tempPermissions = rolePermissionService.getRolePermissionsById(rolePermission.getRoleId());

        return ResponseEntity.status(HttpStatus.OK).body(tempPermissions);
    }

    @PreAuthorize("hasAuthority('CAN_DELETE_ROLE_PERMISSION')")
    @RequestMapping(value = ROLE_PERMISSION_ENDPOINTS.DELETE, method = RequestMethod.POST)
    public ResponseEntity<?> updateRolePermission(@RequestBody RolePermission rolePermission) {
        RolePermission tempRolePermission = rolePermissionService.handleRolePermissionDeletion(rolePermission);

        if (tempRolePermission == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(tempRolePermission);
        }

        return ResponseEntity.status(HttpStatus.OK).body(rolePermission);
    }

    protected static final class ROLE_PERMISSION_ENDPOINTS {
        protected static final String ROLE_PERMISSION = "/role_permission";

        protected static final String ADD = ROLE_PERMISSION + "/add";

        protected static final String GET = ROLE_PERMISSION + "/get";

        protected static final String GET_ALL = ROLE_PERMISSION + "/getAll";

        protected static final String DELETE = ROLE_PERMISSION + "/delete";
    }
}
