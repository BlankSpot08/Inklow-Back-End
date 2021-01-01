package com.example.inklow.daoTest;

import com.example.inklow.builder.RoleBuilder;
import com.example.inklow.dao.RoleDao;
import com.example.inklow.entities.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class RoleDaoTest {
    private final RoleDao roleDao;

    @Autowired
    public RoleDaoTest(@Qualifier("testRoleConfig") RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Test
    void getRoleById() {
        UUID id = UUID.fromString("");

        Role role = roleDao.getRoleById(id);

        Assertions.assertNotNull(role);

        System.out.println(role.getId());
        System.out.println(role.getName());
        System.out.println(role.getDescription());
        System.out.println();

    }

    @Test
    void getRoleByUsername() {
        String name = "User";

        Role role = roleDao.getRoleByName(name);

        Assertions.assertNotNull(role);

        System.out.println(role.getId());
        System.out.println(role.getName());
        System.out.println(role.getDescription());
        System.out.println();
    }

    @Test
    void getRoles() {
        roleDao.getListOfRole().forEach(e -> {
            System.out.println(e.getId());
            System.out.println(e.getName());
            System.out.println(e.getDescription());
            System.out.println();
        });
    }

    @Test
    void insertRole() {
        String name = "";
        String description = "";

//        String name = "User";
//        String description = "";

//        String name = "Admin";
//        String description = "";

        Role role = new RoleBuilder()
                .name(name)
                .description(description)
                .build();

        Assertions.assertNotNull(roleDao.addRole(role));

    }

    @Test
    void deleteRole() {
        UUID id = UUID.fromString("abbe02db-2b5f-4331-8c3d-0e059697ba7e");

        Role role = new RoleBuilder()
                .id(id)
                .build();

        Assertions.assertNotNull(roleDao.removeRole(role));
    }
}
