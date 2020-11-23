package com.example.inklow.daoImp;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class UserRoleDaoImp implements UserRoleDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RolePermissionsDao rolePermissionsDao;

    @Override
    public List<Role> getRolesByUserId(UUID id) {
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
    public List<Role> getRolesByUserUsername(String username) {
//        String query = "SELECT r.id, r.name, r.description\n" +
//                "FROM user_roles\n" +
//                "JOIN roles r on r.id = user_roles.roleId\n" +
//                "JOIN users u on u.id = user_roles.userId\n" +
//                "WHERE u.username = ?";
//
//        List<Role> roles = jdbcTemplate.query(query, new Object[] {username}, (rs, rowNum) -> new Role(
//                UUID.fromString(rs.getString("id")),
//                rs.getString("name"),
//                rs.getString("description"),
//                permissionsDao.getRolePermissionsById(UUID.fromString(rs.getString("id"))
//                )));
//
////        List<Role> roles = jdbcTemplate.query(query, new Object[] {id}, new UserRoleMapper());
        return null;
    }

    @Override
    public Role getRoleById(UUID id) {
        return null;
    }
}
