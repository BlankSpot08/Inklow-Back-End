package com.example.inklow.dao;

import com.example.inklow.entities.Role;

import java.util.List;
import java.util.UUID;

public interface UserRoleDao {
    public List<Role> getUserRolesByUserId(UUID id);
    public List<Role> getUserRolesByUserUsername(String username);
}
