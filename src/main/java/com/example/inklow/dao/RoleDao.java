package com.example.inklow.dao;

import com.example.inklow.entities.Role;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RoleDao {
    public List<Role> getListOfRole();
    public Role getRoleById(UUID id);
    public Role getRoleByName(String name);
}
