package com.example.inklow.dao;

import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;

import java.util.List;
import java.util.UUID;

public interface RolePermissionsDao {
    public List<Permission> getRolePermissionsById(UUID id);
    public List<Permission> getRolePermissionsByName(String name);
}
