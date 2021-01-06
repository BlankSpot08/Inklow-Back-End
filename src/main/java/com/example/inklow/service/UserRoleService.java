package com.example.inklow.service;

import com.example.inklow.entities.Role;
import com.example.inklow.entities.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserRoleService {
    List<UserRole> getListOfUserRoles();

    List<Role> getUserRolesById(UUID id);

    UserRole handleUserRoleRegistration(UserRole userRole);

    UserRole handleUserRoleDeletion(UserRole userRole);
    Boolean handleAllUserRoleDeletion();

    int userRoleCount();
}
