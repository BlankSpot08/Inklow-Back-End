package com.example.inklow.dao;

import com.example.inklow.entities.Role;
import com.example.inklow.entities.UserRole;

import java.util.List;
import java.util.UUID;

public interface UserRoleDao {
    List<UserRole> getListOfUserRoles();

    List<Role> getUserRolesByUserId(UUID id);

    UserRole addUserRole(UserRole userRole);
    UserRole removeUserRole(UserRole userRole);

    Boolean removeAllUserRole();
}
