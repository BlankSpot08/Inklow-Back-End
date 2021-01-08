package com.example.inklow.controller;

import com.example.inklow.service.RolePermissionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolePermissionController {
    public final RolePermissionService rolePermissionService;

    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }


//    @PreAuthorize(value = "hasAnyAuthority()")
//    @RequestMapping(value = "{URL.USER.GET_ALL_USER}", method = RequestMethod.GET)
//    public ResponseEntity<?> getAllUsers() {
//        List<User> listOfUsers = userService.getListOfUsers();
//
//        return ResponseEntity.status(HttpStatus.OK).body(listOfUsers);
//    }

}
