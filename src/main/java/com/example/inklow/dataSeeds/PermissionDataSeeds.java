package com.example.inklow.dataSeeds;

import com.example.inklow.entities.Permission;
import com.example.inklow.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
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
            // User
            Permission viewUserProfile = new Permission.Builder()
                    .name("CAN_VIEW_USER_PROFILE")
                    .description("")
                    .build();

            Permission deleteUserProfile = new Permission.Builder()
                    .name("CAN_DELETE_USER_PROFILE")
                    .description("")
                    .build();

            Permission updateUserProfile = new Permission.Builder()
                    .name("CAN_EDIT_USER_PROFILE")
                    .description("")
                    .build();

            // Forum
            Permission createThread = new Permission.Builder()
                    .name("CAN_CREATE_THREAD")
                    .description("")
                    .build();

            Permission viewThread = new Permission.Builder()
                    .name("CAN_VIEW_THREAD")
                    .description("")
                    .build();

            Permission deleteThread = new Permission.Builder()
                    .name("CAN_DELETE_THREAD")
                    .description("")
                    .build();

            Permission updateThread = new Permission.Builder()
                    .name("CAN_UPDATE_THREAD")
                    .description("")
                    .build();

            // Permission
            Permission viewPermission = new Permission.Builder()
                    .name("CAN_VIEW_PERMISSION")
                    .description("")
                    .build();

            // Role
            Permission createRole = new Permission.Builder()
                    .name("CAN_CREATE_ROLE")
                    .description("")
                    .build();

            Permission viewRole = new Permission.Builder()
                    .name("CAN_VIEW_ROLE")
                    .description("")
                    .build();

            Permission deleteRole = new Permission.Builder()
                    .name("CAN_DELETE_ROLE")
                    .description("")
                    .build();

            Permission updateRole = new Permission.Builder()
                    .name("CAN_UPDATE_ROLE")
                    .description("")
                    .build();

            // RolePermission
            Permission createRolePermission = new Permission.Builder()
                    .name("CAN_CREATE_ROLE_PERMISSION")
                    .description("")
                    .build();

            Permission viewRolePermission = new Permission.Builder()
                    .name("CAN_VIEW_ROLE_PERMISSION")
                    .description("")
                    .build();

            Permission deleteRolePermission = new Permission.Builder()
                    .name("CAN_DELETE_ROLE_PERMISSION")
                    .description("")
                    .build();

            Permission updateRolePermission = new Permission.Builder()
                    .name("CAN_UPDATE_ROLE_PERMISSION")
                    .description("")
                    .build();

            // User Permissions
            permissionService.handlePermissionRegistration(viewUserProfile);
            permissionService.handlePermissionRegistration(deleteUserProfile);
            permissionService.handlePermissionRegistration(updateUserProfile);

            // Forum
            permissionService.handlePermissionRegistration(createThread);
            permissionService.handlePermissionRegistration(viewThread);
            permissionService.handlePermissionRegistration(updateThread);
            permissionService.handlePermissionRegistration(deleteThread);

            // Permission
            permissionService.handlePermissionRegistration(viewPermission);

            // Role
            permissionService.handlePermissionRegistration(createRole);
            permissionService.handlePermissionRegistration(viewRole);
            permissionService.handlePermissionRegistration(updateRole);
            permissionService.handlePermissionRegistration(deleteRole);

            // Role Permission
            permissionService.handlePermissionRegistration(createRolePermission);
            permissionService.handlePermissionRegistration(viewRolePermission);
            permissionService.handlePermissionRegistration(updateRolePermission);
            permissionService.handlePermissionRegistration(deleteRolePermission);
        }
    }
}
