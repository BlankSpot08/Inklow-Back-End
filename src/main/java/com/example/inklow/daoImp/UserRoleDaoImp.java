package com.example.inklow.daoImp;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

public class UserRoleDaoImp implements UserRoleDao {
    private final JdbcTemplate jdbcTemplate;
    private final RolePermissionsDao rolePermissionsDao;

    public UserRoleDaoImp(JdbcTemplate jdbcTemplate, RolePermissionsDao rolesPermissionsDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.rolePermissionsDao = rolesPermissionsDao;
    }

    @Override
    public List<Role> getUserRolesByUserId(UUID id) {
        String query = "SELECT r.id, r.name, r.description\n" +
                "FROM user_roles\n" +
                "JOIN roles r on r.id = user_roles.roleId\n" +
                "JOIN users u on u.id = user_roles.userId\n" +
                "WHERE u.id = ?";

        List<Role> roles = jdbcTemplate.query(query, new Object[] {id}, new RoleMapper());

        for (Role role : roles) {
            List<Permission> permissions = rolePermissionsDao.getRolePermissionsById(role.getId());
            role.setPermissions(permissions);
        }

        return roles;
    }

    @Override
    public List<Role> getUserRolesByUserUsername(String username) {
        String query = "SELECT r.id, r.name, r.description\n" +
                "FROM user_roles\n" +
                "JOIN roles r on r.id = user_roles.roleId\n" +
                "JOIN users u on u.id = user_roles.userId\n" +
                "WHERE u.id = ?";

        List<Role> roles = jdbcTemplate.query(query, new Object[] {username}, new RoleMapper());

        for (Role role : roles) {
            List<Permission> permissions = rolePermissionsDao.getRolePermissionsById(role.getId());
            role.setPermissions(permissions);
        }

        return roles;
    }
}
