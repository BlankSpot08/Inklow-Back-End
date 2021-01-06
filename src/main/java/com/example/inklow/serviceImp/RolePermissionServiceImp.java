package com.example.inklow.serviceImp;

import com.example.inklow.dao.RolePermissionDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.RolePermission;
import com.example.inklow.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RolePermissionServiceImp implements RolePermissionService {
    private final RolePermissionDao rolePermissionDao;

    @Autowired
    public RolePermissionServiceImp(RolePermissionDao rolePermissionDao) {
        this.rolePermissionDao = rolePermissionDao;
    }

    @Override
    public List<RolePermission> getListOfUserRoles() {
        return rolePermissionDao.getListOfRolePermissions();
    }

    @Override
    public List<Permission> getRolePermissionsById(UUID id) {
        return rolePermissionDao.getRolePermissionsById(id);
    }

    @Override
    public RolePermission handleRolePermissionRegistration(RolePermission rolePermission) {
        return rolePermissionDao.addRolePermission(rolePermission);
    }

    @Override
    public RolePermission handleRolePermissionDeletion(RolePermission rolePermission) {
        return rolePermissionDao.removeRolePermission(rolePermission);
    }

    @Override
    public Boolean handleAllRolePermissionDeletion() {
        return rolePermissionDao.removeAllRolePermission();
    }

    @Override
    public int rolePermissionCount() {
        return getListOfUserRoles().size();
    }
}
