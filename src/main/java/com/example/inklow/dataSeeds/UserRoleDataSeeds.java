package com.example.inklow.dataSeeds;

import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;
import com.example.inklow.entities.UserRole;
import com.example.inklow.service.RoleService;
import com.example.inklow.service.UserRoleService;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(5)
public class UserRoleDataSeeds implements ApplicationRunner {
    private final UserRoleService userRoleService;
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserRoleDataSeeds(UserRoleService userRoleService, UserService userService, RoleService roleService) {
        this.userRoleService = userRoleService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadUserRoleDatabaseData();
    }

    private void loadUserRoleDatabaseData() {
        if (userRoleService.userRoleCount() == 0) {
            UserRole userRole = loadUserRole("BlankSpot08", "Admin");
        }
    }

    private UserRole loadUserRole(String username, String roleName) {
        User user = userService.findUserByUsername(username);
        Role role = roleService.getListByName(roleName);

        UserRole userRole = new UserRole.Builder()
                .userId(user.getId())
                .roleId(role.getId())
                .build();

        userRoleService.handleUserRoleRegistration(userRole);

        return userRole;
    }
}
