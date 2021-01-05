package com.example.inklow.service;

import com.example.inklow.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface RoleService {
    List<Role> getListOfRoles();

    Role getListById(UUID id);
    Role getListByName(String name);

    Role handleRoleRegistration(Role role);

    Role handleRoleDeletion(Role role);

    int roleCount();
}
