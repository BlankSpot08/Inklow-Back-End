package com.example.inklow.serviceImp;

import com.example.inklow.dao.PermissionDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PermissionServiceImp implements PermissionService {
    private final PermissionDao permissionDao;

    @Autowired
    public PermissionServiceImp(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public List<Permission> getListOfPermission() {
        return permissionDao.getListOfPermission();
    }

    @Override
    public Permission getPermissionById(UUID id) {
        return permissionDao.getPermissionById(id);
    }

    @Override
    public Permission getPermissionByName(String name) {
        return permissionDao.getPermissionByName(name);
    }

    @Override
    public Permission handlePermissionRegistration(Permission permission) {
        return permissionDao.addPermission(permission);
    }

    @Override
    public Permission handlePermissionDeletion(Permission permission) {
        return permissionDao.removePermission(permission);
    }

    @Override
    public Boolean handleAllPermissionDeletion() {
        return permissionDao.removeAllPermission();
    }

    @Override
    public int permissionCount() {
        return getListOfPermission().size();
    }
}
