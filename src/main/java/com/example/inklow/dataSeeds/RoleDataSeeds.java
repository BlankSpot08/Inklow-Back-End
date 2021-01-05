package com.example.inklow.dataSeeds;

import com.example.inklow.entities.Role;
import com.example.inklow.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class RoleDataSeeds implements ApplicationRunner {
    private final RoleService roleService;

    @Autowired
    public RoleDataSeeds(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(2);
        loadRoleDatabaseData();
    }

    private void loadRoleDatabaseData() {
        if (roleService.roleCount() == 0) {
            Role admin = new Role.Builder()
                    .name("Admin")
                    .description("")
                    .build();

            Role user = new Role.Builder()
                    .name("User")
                    .description("")
                    .build();

            roleService.handleRoleRegistration(admin);

            roleService.handleRoleRegistration(user);
        }
    }
}
