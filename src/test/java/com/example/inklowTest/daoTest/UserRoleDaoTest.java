package com.example.inklowTest.daoTest;

import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.Role;
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
    void getUserRolesById() {
        UUID id = UUID.fromString("576b4a01-b907-457e-8540-82e41bfb97c6");

        List<Role> roles = userRoleDao.getUserRolesByUserId(id);

        roles.forEach(e -> {
            System.out.println(e.getId());
            System.out.println(e.getName());
            System.out.println(e.getDescription());
            System.out.println();
        });
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

        UserRole userRole = new UserRole.Builder()
                .userId(userId)
                .roleId(roleId)
                .build();

        Assertions.assertNotNull(userRoleDao.addUserRole(userRole));
    }

    @Test
    void deleteUserRole() {
        UUID userId = UUID.fromString("");
        UUID roleId = UUID.fromString("");

        UserRole userRole = new UserRole.Builder()
                .userId(userId)
                .roleId(roleId)
                .build();

        Assertions.assertNotNull(userRoleDao.removeUserRole(userRole));
    }

    @Test
    void deleteAllUserRole() {
        Assertions.assertNotNull(userRoleDao.removeAllUserRole());
    }
}