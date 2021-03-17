package com.example.inklow.dataSeeds;

import com.example.inklow.entities.Permission;
import com.example.inklow.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
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
                    "CAN_UPDATE_ROLE_PERMISSION",

                    // NEW

                    // Question
                    "CAN_CREATE_QUESTION",
                    "CAN_VIEW_ALL_QUESTION",
                    "CAN_VIEW_QUESTION",
                    "CAN_DELETE_QUESTION",
                    "CAN_UPDATE_QUESTION",

                    // CATEGORY QUESTION
                    "CAN_CREATE_CATEGORY_QUESTION",
                    "CAN_VIEW_ALL_CATEGORY_QUESTION",
                    "CAN_VIEW_CATEGORY_QUESTION",
                    "CAN_DELETE_CATEGORY_QUESTION",
                    "CAN_UPDATE_CATEGORY_QUESTION",

                    // Inquiry
                    "CAN_CREATE_INQUIRY",
                    "CAN_VIEW_ALL_INQUIRY",
                    "CAN_VIEW_INQUIRY",
                    "CAN_DELETE_INQUIRY",
                    "CAN_UPDATE_INQUIRY",

                    // CATEGORY INQUIRY
                    "CAN_CREATE_CATEGORY_INQUIRY",
                    "CAN_VIEW_ALL_CATEGORY_INQUIRY",
                    "CAN_VIEW_CATEGORY_INQUIRY",
                    "CAN_DELETE_CATEGORY_INQUIRY",
                    "CAN_UPDATE_CATEGORY_INQUIRY",

                    // INQUIRY CATEGORY
                    "CAN_CREATE_INQUIRY_CATEGORY",
                    "CAN_VIEW_ALL_INQUIRY_CATEGORY",
                    "CAN_VIEW_INQUIRY_CATEGORY",
                    "CAN_DELETE_INQUIRY_CATEGORY",
                    "CAN_UPDATE_INQUIRY_CATEGORY",

                    // REPORT INQUIRY
                    "CAN_CREATE_REPORT_INQUIRY",
                    "CAN_VIEW_ALL_REPORT_INQUIRY",
                    "CAN_VIEW_REPORT_INQUIRY",
                    "CAN_DELETE_REPORT_INQUIRY",
                    "CAN_UPDATE_REPORT_INQUIRY",

                    // USER REPORT INQUIRY
                    "CAN_CREATE_USER_REPORT_INQUIRY",
                    "CAN_VIEW_ALL_USER_REPORT_INQUIRY",
                    "CAN_VIEW_USER_REPORT_INQUIRY",
                    "CAN_DELETE_USER_REPORT_INQUIRY",
                    "CAN_UPDATE_USER_REPORT_INQUIRY",
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
