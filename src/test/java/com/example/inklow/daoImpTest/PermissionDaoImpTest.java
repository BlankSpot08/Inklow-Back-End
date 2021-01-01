package com.example.inklow.daoImpTest;

import com.example.inklow.dao.PermissionDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PermissionDaoImpTest implements PermissionDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PermissionDaoImpTest(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Permission> getListOfPermission() {
        String query = "SELECT * FROM permissions";

        List<Permission> permissions = jdbcTemplate.query(query, new PermissionMapper());

        return permissions;
    }

    @Override
    public Permission getPermissionById(String id) {
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

        jdbcTemplate.update(query, permission.getName(), permission.getDescription());

        return permission;
    }

    @Override
    public Permission removePermission(Permission permission) {
        String query = "DELETE FROM permission WHERE id = ?";

        jdbcTemplate.update(query, permission.getId());

        return permission;
    }
}
