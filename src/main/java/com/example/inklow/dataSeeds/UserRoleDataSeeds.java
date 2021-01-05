package com.example.inklow.dataSeeds;

import com.example.inklow.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(5)
public class UserRoleDataSeeds implements ApplicationRunner {
    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleDataSeeds(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(5);
        loadUserRoleDatabaseData();
    }

    private void loadUserRoleDatabaseData() {
        if (userRoleService.userRoleCount() == 0) {

        }
    }
}
