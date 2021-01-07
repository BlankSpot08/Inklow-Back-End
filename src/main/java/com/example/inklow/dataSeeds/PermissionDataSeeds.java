package com.example.inklow.dataSeeds;

import com.example.inklow.entities.Permission;
import com.example.inklow.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class PermissionDataSeeds implements ApplicationRunner {
    private final PermissionService permissionService;

    @Autowired
    public PermissionDataSeeds(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadPermissionDatabaseData();
    }

    private void loadPermissionDatabaseData() {
        if (permissionService.permissionCount() == 0) {
            String[] permissions = {
                    // User
                    "CAN_VIEW_ALL_USER_PROFILE",
                    "CAN_VIEW_USER_PROFILE",
                    "CAN_DELETE_USER_PROFILE",
                    "CAN_EDIT_USER_PROFILE",

                    // Forum
                    "CAN_CREATE_THREAD",
                    "CAN_VIEW_THREAD",
                    "CAN_VIEW_ALL_THREAD",
                    "CAN_DELETE_THREAD",
                    "CAN_UPDATE_THREAD",

                    // Permission
                    "CAN_VIEW_ALL_PERMISSION",
                    "CAN_VIEW_PERMISSION",

                    // Roles
                    "CAN_CREATE_ROLE",
                    "CAN_VIEW_ALL_ROLE",
                    "CAN_VIEW_ROLE",
                    "CAN_DELETE_ROLE",
                    "CAN_UPDATE_ROLE",

                    // Role Permission
                    "CAN_CREATE_ROLE_PERMISSION",
                    "CAN_VIEW_ALL_ROLE_PERMISSION",
                    "CAN_VIEW_ROLE_PERMISSION",
                    "CAN_DELETE_ROLE_PERMISSION",
                    "CAN_UPDATE_ROLE_PERMISSION"
            };

            for (String s : permissions) {
                Permission permission = new Permission.Builder()
                        .name(s)
                        .description("")
                        .build();

                permissionService.handlePermissionRegistration(permission);
            }
        }
    }
}
