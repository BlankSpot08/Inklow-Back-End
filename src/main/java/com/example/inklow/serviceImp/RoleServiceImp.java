package com.example.inklow.serviceImp;

import com.example.inklow.dao.RoleDao;
import com.example.inklow.entities.Role;
import com.example.inklow.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImp implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getListOfRoles() {
        return roleDao.getListOfRole();
    }

    @Override
    public Role getListById(UUID id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public Role getListByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public Role handleRoleRegistration(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public Role handleRoleDeletion(Role role) {
        return roleDao.removeRole(role);
    }

    @Override
    public int roleCount() {
        return getListOfRoles().size();
    }
}
