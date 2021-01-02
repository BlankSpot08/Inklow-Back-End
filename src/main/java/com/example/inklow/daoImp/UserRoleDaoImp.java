package com.example.inklow.daoImp;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.UserRole;
import com.example.inklow.mapper.RoleMapper;
import com.example.inklow.mapper.UserRolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRoleDaoImp implements UserRoleDao {
    private final JdbcTemplate jdbcTemplate;
    private final RolePermissionsDao rolePermissionsDao;

    @Autowired
    public UserRoleDaoImp(final JdbcTemplate jdbcTemplate, final RolePermissionsDao rolesPermissionsDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.rolePermissionsDao = rolesPermissionsDao;
    }

    @Override
    public List<Role> getUserRolesByUserId(UUID id) {
        String query = "SELECT * " +
                "FROM user_roles " +
                "JOIN roles r ON r.id = user_roles.roleId " +
                "WHERE user_roles.userId = ?";
//        String query = "SELECT r.id, r.name, r.description\n" +
//                "FROM user_roles\n" +
//                "JOIN roles r on r.id = user_roles.roleId\n" +
//                "JOIN users u on u.id = user_roles.userId\n" +
//                "WHERE u.id = ?";

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

    @Override
    public UserRole addUserRole(UserRole userRole) {
        String query = "INSERT INTO user_roles(userId, roleId)" +
                "VALUES(?, ?)";

        int statusCode = jdbcTemplate.update(query, userRole.getUserId(), userRole.getRoleId());

        if (statusCode == 0) {
            return null;
        }

        return userRole;
    }

    @Override
    public List<UserRole> getListOfUserRoles() {
        String query = "SELECT * FROM user_roles";

        List<UserRole> userRoles = jdbcTemplate.query(query, new UserRolesMapper());

        return userRoles;
    }
}
