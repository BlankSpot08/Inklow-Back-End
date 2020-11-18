package com.example.inklow.dao;

import com.example.inklow.entities.Permission;

import java.util.List;

public interface PermissionDao {
    public List<Permission> getListOfPermission();
    public Permission getPermissionById(String id);
    public Permission getPermissionByName(String name);
}
