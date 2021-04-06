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
import org.springframework.jdbc.BadSqlGrammarException;
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
        try {
            rolePermissionService.rolePermissionCount();
        } catch (BadSqlGrammarException e) {
            String[] userRoles = {
                    "CAN_VIEW_USER_PROFILE",
                    "CAN_DELETE_USER_PROFILE",
                    "CAN_EDIT_USER_PROFILE"
            };

            String[] user = loadRolePermissions("User", userRoles);

            String[] supportRoles = {
                    "CAN_CREATE_QUESTION",
                    "CAN_VIEW_ALL_QUESTION",
                    "CAN_VIEW_QUESTION",
                    "CAN_DELETE_QUESTION",
                    "CAN_UPDATE_QUESTION",

                    "CAN_CREATE_CATEGORY_QUESTION",
                    "CAN_VIEW_ALL_CATEGORY_QUESTION",
                    "CAN_VIEW_CATEGORY_QUESTION",
                    "CAN_DELETE_CATEGORY_QUESTION",
                    "CAN_UPDATE_CATEGORY_QUESTION",

                    "CAN_CREATE_INQUIRY",
                    "CAN_VIEW_ALL_INQUIRY",
                    "CAN_VIEW_INQUIRY",
                    "CAN_DELETE_INQUIRY",
                    "CAN_UPDATE_INQUIRY",

                    "CAN_CREATE_CATEGORY_INQUIRY",
                    "CAN_VIEW_ALL_CATEGORY_INQUIRY",
                    "CAN_VIEW_CATEGORY_INQUIRY",
                    "CAN_DELETE_CATEGORY_INQUIRY",
                    "CAN_UPDATE_CATEGORY_INQUIRY",

                    "CAN_CREATE_INQUIRY_CATEGORY",
                    "CAN_VIEW_ALL_INQUIRY_CATEGORY",
                    "CAN_VIEW_INQUIRY_CATEGORY",
                    "CAN_DELETE_INQUIRY_CATEGORY",
                    "CAN_UPDATE_INQUIRY_CATEGORY",

                    "CAN_CREATE_REPORT_INQUIRY",
                    "CAN_VIEW_ALL_REPORT_INQUIRY",
                    "CAN_VIEW_REPORT_INQUIRY",
                    "CAN_DELETE_REPORT_INQUIRY",
                    "CAN_UPDATE_REPORT_INQUIRY",

                    "CAN_CREATE_USER_REPORT_INQUIRY",
                    "CAN_VIEW_ALL_USER_REPORT_INQUIRY",
                    "CAN_VIEW_USER_REPORT_INQUIRY",
                    "CAN_DELETE_USER_REPORT_INQUIRY",
                    "CAN_UPDATE_USER_REPORT_INQUIRY",
            };

            String[] support = loadRolePermissions("Support", supportRoles);

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
                    "CAN_UPDATE_ROLE_PERMISSION",

                    "CAN_CREATE_QUESTION",
                    "CAN_VIEW_ALL_QUESTION",
                    "CAN_VIEW_QUESTION",
                    "CAN_DELETE_QUESTION",
                    "CAN_UPDATE_QUESTION",

                    "CAN_CREATE_CATEGORY_QUESTION",
                    "CAN_VIEW_ALL_CATEGORY_QUESTION",
                    "CAN_VIEW_CATEGORY_QUESTION",
                    "CAN_DELETE_CATEGORY_QUESTION",
                    "CAN_UPDATE_CATEGORY_QUESTION",

                    "CAN_CREATE_INQUIRY",
                    "CAN_VIEW_ALL_INQUIRY",
                    "CAN_VIEW_INQUIRY",
                    "CAN_DELETE_INQUIRY",
                    "CAN_UPDATE_INQUIRY",

                    "CAN_CREATE_CATEGORY_INQUIRY",
                    "CAN_VIEW_ALL_CATEGORY_INQUIRY",
                    "CAN_VIEW_CATEGORY_INQUIRY",
                    "CAN_DELETE_CATEGORY_INQUIRY",
                    "CAN_UPDATE_CATEGORY_INQUIRY",

                    "CAN_CREATE_INQUIRY_CATEGORY",
                    "CAN_VIEW_ALL_INQUIRY_CATEGORY",
                    "CAN_VIEW_INQUIRY_CATEGORY",
                    "CAN_DELETE_INQUIRY_CATEGORY",
                    "CAN_UPDATE_INQUIRY_CATEGORY",

                    "CAN_CREATE_REPORT_INQUIRY",
                    "CAN_VIEW_ALL_REPORT_INQUIRY",
                    "CAN_VIEW_REPORT_INQUIRY",
                    "CAN_DELETE_REPORT_INQUIRY",
                    "CAN_UPDATE_REPORT_INQUIRY",

                    "CAN_CREATE_USER_REPORT_INQUIRY",
                    "CAN_VIEW_ALL_USER_REPORT_INQUIRY",
                    "CAN_VIEW_USER_REPORT_INQUIRY",
                    "CAN_DELETE_USER_REPORT_INQUIRY",
                    "CAN_UPDATE_USER_REPORT_INQUIRY",
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
