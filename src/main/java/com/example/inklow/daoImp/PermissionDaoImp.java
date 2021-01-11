package com.example.inklow.daoImp;

import com.example.inklow.controller.RoleController;
import com.example.inklow.dao.PermissionDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PermissionDaoImp implements PermissionDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PermissionDaoImp(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Permission> getListOfPermission() {
        String query = "SELECT * FROM permissions";

        List<Permission> permissions = jdbcTemplate.query(query, new PermissionMapper());

        return permissions;
    }

    @Override
    public Permission getPermissionById(UUID id) {
        String query = "SELECT * FROM permissions WHERE id = ?";

        Permission permission = jdbcTemplate.queryForObject(query, new Object[] {id}, new PermissionMapper());

        return permission;
    }

    @Override
    public Permission getPermissionByName(String name) {
        String query = "SELECT * FROM permissions WHERE name = ?";

        Permission permission = jdbcTemplate.queryForObject(query, new Object[] {name}, new PermissionMapper());

        return permission;
    }

    @Override
    public Permission addPermission(Permission permission) {
        String query = "INSERT INTO permissions" +
                "(name, description) " +
                "VALUES (?, ?)";

        int statusCode = jdbcTemplate.update(query, permission.getName(), permission.getDescription());

        if (statusCode == 0) {
            return null;
        }

        return permission;
    }

    @Override
    public Permission removePermission(Permission permission) {
        String query = "DELETE FROM permissions WHERE id = ?";

        int statusCode = jdbcTemplate.update(query, permission.getId());

        if (statusCode == 0) {
            return null;
        }

        return permission;
    }

    @Override
    public Boolean removeAllPermission() {
        String query = "DELETE FROM permissions";

        int statusCode = jdbcTemplate.update(query);

        if (statusCode == 0) {
            return null;
        }

        return true;
    }

    @Override
    public Permission updatePermisison(Permission permission) {
        String query = "UPDATE permission " +
                "SET name = ?, description = ? " +
                "WHERE id = ?";

        int statusQuery = jdbcTemplate.update(query, permission.getName(), permission.getDescription(), permission.getId());

        if (statusQuery == 0) {
            return null;
        }

        return permission;
    }
}
