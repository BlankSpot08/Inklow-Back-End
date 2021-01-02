package com.example.inklow.daoTest;

import com.example.inklow.builder.UserRolesBuilder;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.UserRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class UserRoleDaoTest {
    private final UserRoleDao userRoleDao;

    @Autowired
    public UserRoleDaoTest(@Qualifier("testUserRoleConfig") UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Test
    void getUserRole() {
        List<UserRole> userRole = userRoleDao.getListOfUserRoles();

        userRole.forEach(e -> {
            System.out.println(e.getUserId());
            System.out.println(e.getRoleId());
            System.out.println();
        });
    }

    @Test
    void insertUserRole() {
        UUID userId = UUID.fromString("576b4a01-b907-457e-8540-82e41bfb97c6");
        UUID roleId = UUID.fromString("675d197f-ec1d-4982-88c1-719e0324f5bd");

        UserRole userRole = new UserRolesBuilder(userId, roleId)
                .build();

        Assertions.assertNotNull(userRoleDao.addUserRole(userRole));
    }
}
