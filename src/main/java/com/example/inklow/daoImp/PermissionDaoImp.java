package com.example.inklow.daoImp;

import com.example.inklow.dao.PermissionDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Set;

public class PermissionDaoImp implements PermissionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PermissionDaoImp() { }

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
}
