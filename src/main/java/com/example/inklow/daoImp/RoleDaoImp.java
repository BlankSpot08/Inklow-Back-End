package com.example.inklow.daoImp;

import com.example.inklow.dao.RoleDao;
import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class RoleDaoImp implements RoleDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RolePermissionsDao rolePermissionsDao;

    public RoleDaoImp() { }

    @Override
    public List<Role> getListOfRole() {
        return null;
    }

    @Override
    public Role getRoleById(UUID id) {
        String query = "SELECT * FROM roles WHERE id = ?";

        Role role = jdbcTemplate.queryForObject(query, new Object[]{id}, new RoleMapper());

        List<Permission> permissions = rolePermissionsDao.getRolePermissionsById(role.getId());
        role.setPermissions(permissions);

        return role;
    }

    @Override
    public Role getRoleByName(String authority) {
        return null;
    }
}
