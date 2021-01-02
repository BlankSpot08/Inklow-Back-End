package com.example.inklow.daoTest;

import com.example.inklow.builder.PermissionBuilder;
import com.example.inklow.dao.PermissionDao;
import com.example.inklow.entities.Permission;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class PermissionDaoTest {
    private PermissionDao permissionDao;

    @Autowired
    public PermissionDaoTest(@Qualifier("testPermissionConfig") PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Test
    void getPermissionByName() {
        String name = "";

        Permission permission = permissionDao.getPermissionByName(name);

        Assertions.assertNotNull(permission);

        System.out.println(permission.getName());
        System.out.println(permission.getDescription());
        System.out.println();
    }

    @Test
    void getPermissionById() {
        UUID id = UUID.fromString("");

        Permission permission = permissionDao.getPermissionById(id);

        Assertions.assertNotNull(permission);

        System.out.println(permission.getName());
        System.out.println(permission.getDescription());
        System.out.println();
    }

    @Test
    void getPermissions() {
        List<Permission> getPermissions = permissionDao.getListOfPermission();

        getPermissions.forEach(e -> {
            System.out.println(e.getId());
            System.out.println(e.getName());
            System.out.println(e.getDescription());
            System.out.println();
        });
    }

    @Test
    void insertPermission() {
        String name = "CAN_EDIT_USER";
        String description = "";

//        String name = "CAN_VIEW_USER";
//        String description = "";

        Permission permission = new PermissionBuilder()
                .name(name)
                .description(description)
                .build();

        System.out.println(permissionDao.addPermission(permission));;
    }

    @Test
    void deletePermission() {
        UUID id = UUID.fromString("7e1f0712-a0f7-4801-bf55-1d1249caf08c");

        Permission permission = new PermissionBuilder()
                .id(id)
                .build();

        Assertions.assertNotNull(permissionDao.removePermission(permission));
    }

    @Test
    void deleteAllPermission() {
        Assertions.assertNotNull(permissionDao.removeAllPermission());
    }
}
