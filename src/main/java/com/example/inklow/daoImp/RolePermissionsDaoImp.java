package com.example.inklow.daoImp;

import com.example.inklow.dao.RoleDao;
import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.entities.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class RolePermissionsDaoImp implements RolePermissionsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Permission> getRolePermissionsById(UUID id) {
        String query = "SELECT p.id, p.name, p.description\n" +
                "FROM role_permissions\n" +
                "JOIN permissions p on p.id = role_permissions.permissionId\n" +
                "JOIN roles r on r.id = role_permissions.roleId\n" +
                "WHERE r.id = ?";

        List<Permission> roles = jdbcTemplate.query(query, new Object[] {id}, new BeanPropertyRowMapper<>(Permission.class));

        return roles;
    }
}

