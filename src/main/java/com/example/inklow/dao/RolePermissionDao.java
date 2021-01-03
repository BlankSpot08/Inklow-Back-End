package com.example.inklow.dao;

import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.RolePermission;

import java.util.List;
import java.util.UUID;

public interface RolePermissionDao {
    List<Permission> getRolePermissionsById(UUID id);

    List<RolePermission> getListOfRolePermissions();

    RolePermission addRolePermission(RolePermission permission);
    RolePermission removeRolePermission(RolePermission rolePermission);

    Boolean removeAllRolePermission();
}
