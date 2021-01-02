package com.example.inklow.dao;

import com.example.inklow.entities.Permission;

import java.util.List;
import java.util.UUID;

public interface PermissionDao {
    List<Permission> getListOfPermission();
    Permission getPermissionById(UUID id);
    Permission getPermissionByName(String name);

    Permission addPermission(Permission permission);
    Permission removePermission(Permission permission);

    Boolean removeAllPermission();
}
