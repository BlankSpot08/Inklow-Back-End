package com.example.inklow.dataSeeds;

import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.RolePermission;
import com.example.inklow.service.PermissionService;
import com.example.inklow.service.RolePermissionService;
import com.example.inklow.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(4)
public class RolePermissionDataSeeds implements ApplicationRunner {
    private final RolePermissionService rolePermissionService;
    private final RoleService roleService;
    private final PermissionService permissionService;

    @Autowired
    public RolePermissionDataSeeds(RolePermissionService rolePermissionService, PermissionService permissionService, RoleService roleService) {
        this.rolePermissionService = rolePermissionService;
        this.permissionService = permissionService;
        this.roleService = roleService;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadRolePermissionDatabaseData();
    }

    private void loadRolePermissionDatabaseData() {
        if (rolePermissionService.rolePermissionCount() == 0) {
            String[] userRoles = {
                    "CAN_VIEW_USER_PROFILE",
                    "CAN_DELETE_USER_PROFILE",
                    "CAN_EDIT_USER_PROFILE"
            };

            String[] user = loadRolePermissions("User", userRoles);

            String[] adminRoles = {
                    "CAN_VIEW_USER_PROFILE",
                    "CAN_VIEW_ALL_USER_PROFILE",
                    "CAN_DELETE_USER_PROFILE",
                    "CAN_EDIT_USER_PROFILE",

                    "CAN_CREATE_THREAD",
                    "CAN_VIEW_ALL_THREAD",
                    "CAN_VIEW_THREAD",
                    "CAN_DELETE_THREAD",
                    "CAN_UPDATE_THREAD",

                    "CAN_VIEW_ALL_PERMISSION",
                    "CAN_VIEW_PERMISSION",

                    "CAN_CREATE_ROLE",
                    "CAN_VIEW_ALL_ROLE",
                    "CAN_VIEW_ROLE",
                    "CAN_DELETE_ROLE",
                    "CAN_UPDATE_ROLE",

                    "CAN_CREATE_ROLE_PERMISSION",
                    "CAN_VIEW_ALL_ROLE_PERMISSION",
                    "CAN_VIEW_ROLE_PERMISSION",
                    "CAN_DELETE_ROLE_PERMISSION",
                    "CAN_UPDATE_ROLE_PERMISSION"
            };

            String[] admin = loadRolePermissions("Admin", adminRoles);
        }
    }

    private String[] loadRolePermissions(String role, String[] args) {
        Role userRole = roleService.getRoleByName(role);

        String[] userRolesString = args;
        for (String s : userRolesString) {
            Permission permission = permissionService.getPermissionByName(s);

            RolePermission rolePermission = new RolePermission.Builder()
                    .roleId(userRole.getId())
                    .permissionId(permission.getId())
                    .build();

            rolePermissionService.handleRolePermissionRegistration(rolePermission);
        }

        return args;
    }
}
