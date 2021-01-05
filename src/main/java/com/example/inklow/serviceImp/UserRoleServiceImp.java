package com.example.inklow.serviceImp;

import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.UserRole;
import com.example.inklow.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserRoleServiceImp implements UserRoleService {
    private final UserRoleDao userRoleDao;

    @Autowired
    public UserRoleServiceImp(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public List<UserRole> getListOfUserRoles() {
        return userRoleDao.getListOfUserRoles();
    }

    @Override
    public List<Role> getUserRolesById(UUID id) {
        return userRoleDao.getUserRolesByUserId(id);
    }

    @Override
    public UserRole handleUserRoleRegistration(UserRole userRole) {
        return userRoleDao.addUserRole(userRole);
    }

    @Override
    public UserRole handleUserRoleDeletion(UserRole userRole) {
        return userRoleDao.removeUserRole(userRole);
    }

    @Override
    public int userRoleCount() {
        return getListOfUserRoles().size();
    }
}
