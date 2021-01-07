package com.example.inklow.service;

import com.example.inklow.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface RoleService {
    List<Role> getListOfRoles();

    Role getRoleById(UUID id);
    Role getRoleByName(String name);

    Role handleRoleRegistration(Role role);

    Role handleRoleDeletion(Role role);
    Boolean handleAllRoleDeletion();

    Role handleRoleChanges(Role role);

    int roleCount();
}
