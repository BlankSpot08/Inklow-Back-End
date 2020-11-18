package com.example.inklow.daoImp;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class UserRoleDaoImp implements UserRoleDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RolePermissionsDao permissionsDao;

    @Override
    public List<Role> getUserRolesById(UUID id) {
        String query = "SELECT r.id, r.name, r.description\n" +
                "FROM user_roles\n" +
                "JOIN roles r on r.id = user_roles.roleId\n" +
                "JOIN users u on u.id = user_roles.userId\n" +
                "WHERE u.id = ?";

//        List<Role> roles = jdbcTemplate.query(query, new Object[] {id}, new BeanPropertyRowMapper<>(Role.class));
        List<Role> roles = jdbcTemplate.query(query, new Object[] {id}, (rs, rowNum) -> new Role(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getString("description"),
                permissionsDao.getRolePermissionsById(UUID.fromString(rs.getString("id"))
        )));

        return roles;
    }

    @Override
    public Role getRoleById(UUID id) {
        return null;
    }
}
