package com.example.inklow.daoTest;

import com.example.inklow.builder.RoleBuilder;
import com.example.inklow.dao.RoleDao;
import com.example.inklow.entities.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class Roles {
    private final RoleDao roleDao;

    @Autowired
    public Roles(@Qualifier("testRoleConfig") RoleDao roleDao) {
        this.roleDao = roleDao;
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

        Role role = new RoleBuilder()
                .name(name)
                .description(description)
                .build();

        System.out.println(roleDao.addRole(role));

    }

    @Test
    void deleteRole() {
        UUID id = UUID.fromString("");

        Role role = new RoleBuilder()
                .id(id)
                .build();

        System.out.println(roleDao.removeRole(role));
    }
}
