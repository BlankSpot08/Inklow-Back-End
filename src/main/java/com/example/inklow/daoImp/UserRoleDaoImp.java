package com.example.inklow.daoImp;

import com.example.inklow.dao.RolePermissionDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.UserRole;
import com.example.inklow.mapper.RoleMapper;
import com.example.inklow.mapper.UserRolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRoleDaoImp implements UserRoleDao {
    private final JdbcTemplate jdbcTemplate;
    private final RolePermissionDao rolePermissionDao;

    @Autowired
    public UserRoleDaoImp(final JdbcTemplate jdbcTemplate, final RolePermissionDao rolesPermissionsDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.rolePermissionDao = rolesPermissionsDao;
    }

    @Override
    public List<Role> getUserRolesByUserId(UUID id) {
        String query = "" +
                "SELECT * FROM user_roles " +
                "JOIN roles r ON r.id = user_roles.roleId " +
                "WHERE user_roles.userId = ?";

        List<Role> roles = jdbcTemplate.query(query, new Object[] {id}, new RoleMapper());

        for (Role role : roles) {
            List<Permission> permissions = rolePermissionDao.getRolePermissionsById(role.getId());
            role.setPermissions(permissions);
        }

        return roles;
    }

    @Override
    public List<UserRole> getListOfUserRoles() {
        String query = "" +
                "SELECT * " +
                "FROM user_roles";

        List<UserRole> userRoles = jdbcTemplate.query(query, new UserRolesMapper());

        return userRoles;
    }

    @Override
    public UserRole addUserRole(UserRole userRole) {
        String query = "" +
                "INSERT INTO user_roles(userId, roleId) " +
                "VALUES(?, ?)";

        int statusCode = jdbcTemplate.update(query, userRole.getUserId(), userRole.getRoleId());

        if (statusCode == 0) {
            return null;
        }

        return userRole;
    }

    @Override
    public UserRole removeUserRole(UserRole userRole) {
        String query = "" +
                "DELETE FROM user_roles " +
                "WHERE userId = ? AND roleId = ?";

        int statusCode = jdbcTemplate.update(query, userRole.getUserId(), userRole.getRoleId());

        if (statusCode == 0) {
            return null;
        }

        return userRole;
    }

    @Override
    public Boolean removeAllUserRole() {
        String query = "" +
                "DELETE FROM user_roles";

        int statusCode = jdbcTemplate.update(query);

        if (statusCode == 0) {
            return null;
        }

        return true;
    }
}
