package com.example.inklow.dao;

import com.example.inklow.entities.Permission;

import java.util.List;

public interface PermissionDao {
    List<Permission> getListOfPermission();
    Permission getPermissionById(String id);
    Permission getPermissionByName(String name);
}
