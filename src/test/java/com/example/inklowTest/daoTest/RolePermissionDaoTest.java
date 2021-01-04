package com.example.inklowTest.daoTest;

import com.example.inklow.dao.RolePermissionDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.RolePermission;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class RolePermissionDaoTest {
    private final RolePermissionDao rolePermissionDao;

    @Autowired
    public RolePermissionDaoTest(@Qualifier("testRolePermissionConfig") RolePermissionDao rolePermissionDao) {
        this.rolePermissionDao = rolePermissionDao;
    }

    @Test
    void getRolePermissionsById() {
        UUID id = UUID.fromString("675d197f-ec1d-4982-88c1-719e0324f5bd");
//        UUID id = UUID.fromString("df6839e1-1afe-45e5-aaef-357600236f85");

        List<Permission> permissions = rolePermissionDao.getRolePermissionsById(id);

        permissions.forEach(e -> {
            System.out.println(e.getId());
            System.out.println(e.getName());
            System.out.println(e.getDescription());
            System.out.println();
        });
    }

    @Test
    void getRolePermissions() {
        List<RolePermission> getRolePermissions = rolePermissionDao.getListOfRolePermissions();

        getRolePermissions.forEach(e -> {
            System.out.println("Role Id: " + e.getRoleId());
            System.out.println("Permission Id: " + e.getPermissionId());
            System.out.println();
        });
    }

    @Test
    void insertRolePermission() {
        UUID roleId = UUID.fromString("675d197f-ec1d-4982-88c1-719e0324f5bd");
        UUID permissionId = UUID.fromString("4a279c6f-cefd-4bfd-9302-1b6a2fae3dc9");

        RolePermission rolePermission = new RolePermission.Builder()
                .roleId(roleId)
                .permissionId(permissionId)
                .build();

        Assertions.assertNotNull(rolePermissionDao.addRolePermission(rolePermission));
    }

    @Test
    void removeRolePermission() {
        UUID roleId = UUID.fromString("675d197f-ec1d-4982-88c1-719e0324f5bd");
        UUID permissionId = UUID.fromString("4a279c6f-cefd-4bfd-9302-1b6a2fae3dc9");

        RolePermission rolePermission = new RolePermission.Builder()
                .roleId(roleId)
                .permissionId(permissionId)
                .build();

        Assertions.assertNotNull(rolePermissionDao.removeRolePermission(rolePermission));
    }

    @Test
    void RemoveAllPermissions() {
        Assertions.assertNotNull(rolePermissionDao.removeAllRolePermission());
    }
}
