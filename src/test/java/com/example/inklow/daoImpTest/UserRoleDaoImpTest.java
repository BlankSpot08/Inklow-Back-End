package com.example.inklow.daoImpTest;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRoleDaoImpTest implements UserRoleDao {
    private final JdbcTemplate jdbcTemplate;
    private final RolePermissionsDao rolePermissionsDao;

    @Autowired
    public UserRoleDaoImpTest(JdbcTemplate jdbcTemplate, RolePermissionsDao rolesPermissionsDao) {
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
