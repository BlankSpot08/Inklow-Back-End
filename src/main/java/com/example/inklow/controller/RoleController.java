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
@RequestMapping(value = "/api" + RoleController.ENDPOINTS.ROLE)
public class RoleController {
    private final RoleService roleService;

    protected String testing;

    @Autowired
    public RoleController(final RoleService roleService) {
        this.roleService = roleService;
    }

    @PreAuthorize("hasAnyAuthority('CAN_CREATE_ROLE')")
    @RequestMapping(value = ENDPOINTS.ADD, method = RequestMethod.GET)
    public ResponseEntity<?> addRole() {
        List<Role> listOfRole = roleService.getListOfRoles();

        return ResponseEntity.status(HttpStatus.OK).body(listOfRole);
    }

    @PreAuthorize("hasAnyAuthority('CAN_VIEW_ROLE')")
    @RequestMapping(value = ENDPOINTS.GET, method = RequestMethod.POST)
    public ResponseEntity<?> getRoles(@RequestBody Role role) {
        Role tempRole = roleService.getRoleByName(role.getName());

        return ResponseEntity.status(HttpStatus.OK).body(tempRole);
    }

    @PreAuthorize("hasAnyAuthority('CAN_VIEW_ALL_ROLE')")
    @RequestMapping(value = ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllRoles() {
        List<Role> listOfRole = roleService.getListOfRoles();

        return ResponseEntity.status(HttpStatus.OK).body(listOfRole);
    }

    @PreAuthorize("hasAnyAuthority('CAN_UPDATE_ROLE')")
    @RequestMapping(value = ENDPOINTS.UPDATE, method = RequestMethod.POST)
    public ResponseEntity<?> updateRole(@RequestBody Role role) {
        Role tempRole = roleService.handleRoleChanges(role);

        return ResponseEntity.status(HttpStatus.OK).body(tempRole);
    }

    @PreAuthorize("hasAnyAuthority('CAN_DELETE_ROLE')")
    @RequestMapping(value = ENDPOINTS.DELETE, method = RequestMethod.POST)
    public ResponseEntity<?> deleteRole(@RequestBody Role role) {
        Role tempRole = roleService.handleRoleDeletion(role);

        return ResponseEntity.status(HttpStatus.OK).body(tempRole);
    }

    protected static final class ENDPOINTS {
        protected static final String ROLE = "/role";

        private static final String ADD = "/add";

        protected static final String GET = "/get";

        protected static final String GET_ALL = "/getAll";

        protected static final String UPDATE = "/update";

        protected static final String DELETE = "/delete";
    }
}
