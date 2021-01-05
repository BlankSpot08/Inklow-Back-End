package com.example.inklow.dataSeeds;

import com.example.inklow.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(4)
public class RolePermissionDataSeeds implements ApplicationRunner {
    private final RolePermissionService rolePermissionService;

    @Autowired
    public RolePermissionDataSeeds(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(4);
        loadRolePermissionDatabaseData();
    }

    private void loadRolePermissionDatabaseData() {
        if (rolePermissionService.rolePermissionCount() == 0) {

        }

    }
}
