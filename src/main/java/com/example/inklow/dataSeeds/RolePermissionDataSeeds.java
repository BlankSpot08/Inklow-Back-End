package com.example.inklow.dataSeeds;

import com.example.inklow.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionDataSeeds implements ApplicationRunner {
    private final RolePermissionService rolePermissionService;

    @Autowired
    public RolePermissionDataSeeds(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadRolePermissionDatabaseData();
    }

    private void loadRolePermissionDatabaseData() {
        if (rolePermissionService.rolePermissionCount() == 0) {

        }

    }
}
