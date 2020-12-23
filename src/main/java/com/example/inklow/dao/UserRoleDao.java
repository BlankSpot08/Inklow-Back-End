package com.example.inklow.dao;

import com.example.inklow.entities.Role;

import java.util.List;
import java.util.UUID;

public interface UserRoleDao {
    List<Role> getUserRolesByUserId(UUID id);
    List<Role> getUserRolesByUserUsername(String username);
}
