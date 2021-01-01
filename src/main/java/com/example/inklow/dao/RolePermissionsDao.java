package com.example.inklow.dao;

import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.RolePermission;

import java.util.List;
import java.util.UUID;

public interface RolePermissionsDao {
    List<Permission> getRolePermissionsById(UUID id);
    List<Permission> getRolePermissionsByName(String name);
    List<RolePermission> getRolePermissions();

    RolePermission addRolePermission(RolePermission permission);
}
