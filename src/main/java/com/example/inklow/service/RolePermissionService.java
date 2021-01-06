package com.example.inklow.service;

import com.example.inklow.entities.Permission;
import com.example.inklow.entities.RolePermission;
import com.example.inklow.entities.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface RolePermissionService {
    List<RolePermission> getListOfUserRoles();

    List<Permission> getRolePermissionsById(UUID id);

    RolePermission handleRolePermissionRegistration(RolePermission rolePermission);

    RolePermission handleRolePermissionDeletion(RolePermission rolePermission);
    Boolean handleAllRolePermissionDeletion();

    int rolePermissionCount();
}
