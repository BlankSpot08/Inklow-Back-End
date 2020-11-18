package com.example.inklow.dao;

import com.example.inklow.entities.Role;

import java.util.List;
import java.util.UUID;

public interface UserRoleDao {
    public List<Role> getUserRolesById(UUID id);
    public Role getRoleById(UUID id);
}
