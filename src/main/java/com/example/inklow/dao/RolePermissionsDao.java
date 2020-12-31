package com.example.inklow.dao;

import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.RolePermissions;

import java.security.Permissions;
import java.util.List;
import java.util.UUID;

public interface RolePermissionsDao {
    List<Permission> getRolePermissionsById(UUID id);
    List<Permission> getRolePermissionsByName(String name);
    List<RolePermissions> getRolePermissions();
}
