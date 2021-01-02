package com.example.inklow.daoImp;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.RolePermission;
import com.example.inklow.mapper.PermissionMapper;
import com.example.inklow.mapper.RoleMapper;
import com.example.inklow.mapper.RolePermissionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RolePermissionsDaoImp implements RolePermissionsDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RolePermissionsDaoImp(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Permission> getRolePermissionsById(UUID id) {
        String query = "SELECT p.id, p.name, p.description " +
                "FROM role_permissions " +
                "JOIN permissions AS p ON role_permissions.permissionId = p.id " +
                "WHERE role_permissions.roleId = ?";

        List<Permission> permissions = jdbcTemplate.query(query, new Object[] {id}, new PermissionMapper());

        return permissions;
    }

    @Override
    public List<RolePermission> getListOfRolePermissions() {
        String query = "SELECT * FROM role_permissions";

        List<RolePermission> rolePermissions = jdbcTemplate.query(query, new RolePermissionsMapper());

        return rolePermissions;
    }

    @Override
    public RolePermission addRolePermission(RolePermission rolePermission) {
        String query = "INSERT INTO role_permissions " +
                "(roleId, permissionId) " +
                "VALUES(?, ?)";

        int statusCode = jdbcTemplate.update(query, rolePermission.getRoleId(), rolePermission.getPermissionId());

        if (statusCode == 0) {
            return null;
        }

        return rolePermission;
    }

    @Override
    public RolePermission removeRolePermission(RolePermission rolePermission) {
        String query = "DELETE FROM role_permissions " +
                "WHERE roleId = ? AND permissionId = ?";

        int statusCode = jdbcTemplate.update(query, rolePermission.getRoleId(), rolePermission.getPermissionId());

        if (statusCode == 0) {
            return null;
        }

        return rolePermission;
    }

    @Override
    public Boolean removeAllRolePermission() {
        String query = "DELETE FROM role_permissions";

        int statusCode = jdbcTemplate.update(query);

        if (statusCode == 0) {
            return null;
        }

        return true;
    }
}

