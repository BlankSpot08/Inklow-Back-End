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
        System.out.println(4);
        loadRolePermissionDatabaseData();
    }

    private void loadRolePermissionDatabaseData() {
        if (rolePermissionService.rolePermissionCount() == 0) {
            Role userRole = roleService.getListByName("User");

            Permission viewUserProfile = permissionService.getPermissionByName("CAN_VIEW_USER_PROFILE");
            Permission deleteUserProfile = permissionService.getPermissionByName("CAN_DELETE_USER_PROFILE");
            Permission editUserProfile = permissionService.getPermissionByName("CAN_EDIT_USER_PROFILE");

            RolePermission userView = new RolePermission.Builder()
                    .roleId(userRole.getId())
                    .permissionId(viewUserProfile.getId())
                    .build();

            RolePermission deleteView = new RolePermission.Builder()
                    .roleId(userRole.getId())
                    .permissionId(deleteUserProfile.getId())
                    .build();

            RolePermission editView = new RolePermission.Builder()
                    .roleId(userRole.getId())
                    .permissionId(editUserProfile.getId())
                    .build();

            rolePermissionService.handleRolePermissionRegistration(userView);
            rolePermissionService.handleRolePermissionRegistration(deleteView);
            rolePermissionService.handleRolePermissionRegistration(editView);
        }

    }
}
