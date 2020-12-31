package com.example.inklow.utils;

import com.example.inklow.builder.PermissionBuilder;
import com.example.inklow.dao.PermissionDao;
import com.example.inklow.entities.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Permissions {
    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    public Permissions(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Test
    void getPermissions() {
        List<Permission> getPermissions = permissionDao.getListOfPermission();

        getPermissions.forEach(e -> {
            System.out.println(e.getName());
            System.out.println(e.getDescription());
            System.out.println();
        });
    }

    @Test
    void insertPermission() {
        String name = "";
        String description = "";

        Permission permission = new PermissionBuilder()
                .name(name)
                .description(description)
                .build();

        System.out.println(permissionDao.addPermission(permission));;
    }
}
