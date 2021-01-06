package com.example.inklow.dao;

import com.example.inklow.entities.Role;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RoleDao {
    List<Role> getListOfRole();
    Role getRoleById(UUID id);
    Role getRoleByName(String name);

    Role addRole(Role role);

    Role removeRole(Role role);
    Boolean removeAllRole();

    Role updateRole(Role role);
}
