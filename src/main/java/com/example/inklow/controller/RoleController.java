package com.example.inklow.controller;

import com.example.inklow.entities.Role;
import com.example.inklow.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api" + RoleController.ROLE_ENDPOINTS.ROLE)
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(final RoleService roleService) {
        this.roleService = roleService;
    }

    @PreAuthorize("hasAnyAuthority(#ROLE_ENDPOINTS.ADD_PERMISSION)")
    @RequestMapping(value = ROLE_ENDPOINTS.ADD, method = RequestMethod.GET)
    public ResponseEntity<?> addRole() {
        List<Role> listOfRole = roleService.getListOfRoles();

        return ResponseEntity.status(HttpStatus.OK).body(listOfRole);
    }

    @PreAuthorize("hasAnyAuthority(#ROLE_ENDPOINTS.GET_PERMISSION)")
    @RequestMapping(value = ROLE_ENDPOINTS.GET, method = RequestMethod.POST)
    public ResponseEntity<?> getRoles(@RequestBody Role role) {
        Role tempRole = roleService.getRoleByName(role.getName());

        return ResponseEntity.status(HttpStatus.OK).body(tempRole);
    }

    @PreAuthorize("hasAnyAuthority(#ROLE_ENDPOINTS.GET_ALL_PERMISSION)")
    @RequestMapping(value = ROLE_ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllRoles() {
        List<Role> listOfRole = roleService.getListOfRoles();

        return ResponseEntity.status(HttpStatus.OK).body(listOfRole);
    }

    @PreAuthorize("hasAnyAuthority(#ROLE_ENDPOINTS.UPDATE_PERMISSION)")
    @RequestMapping(value = ROLE_ENDPOINTS.UPDATE, method = RequestMethod.POST)
    public ResponseEntity<?> updateRole(@RequestBody Role role) {
        Role tempRole = roleService.handleRoleChanges(role);

        return ResponseEntity.status(HttpStatus.OK).body(tempRole);
    }

    @PreAuthorize("hasAnyAuthority(#ROLE_ENDPOINTS.DELETE_PERMISSION)")
    @RequestMapping(value = ROLE_ENDPOINTS.DELETE, method = RequestMethod.POST)
    public ResponseEntity<?> deleteRole(@RequestBody Role role) {
        Role tempRole = roleService.handleRoleDeletion(role);

        return ResponseEntity.status(HttpStatus.OK).body(tempRole);
    }

    @Component
    public static class ROLE_ENDPOINTS {
        protected static final String ROLE = "/role";

        public static final String ADD = "/add";
        public static final String ADD_PERMISSION = "CAN_CREATE_ROLE";

        public static final String GET = "/get";
        public static final String GET_PERMISSION = "CAN_VIEW_ROLE";

        public static final String GET_ALL = "/getAll";
        public static final String GET_ALL_PERMISSION = "CAN_VIEW_ALL_ROLE";

        public static final String UPDATE = "/update";
        public static final String UPDATE_PERMISSION = "CAN_UPDATE_ROLE";

        public static final String DELETE = "/delete";
        public static final String DELETE_PERMISSION = "CAN_DELETE_ROLE";
    }
}
