package com.example.inklow.mapper;

import com.example.inklow.entities.RolePermission;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public final class RolePermissionsMapper implements RowMapper<RolePermission> {
    @Override
    public RolePermission mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RolePermission.Builder()
                .roleId(UUID.fromString(rs.getString("roleId")))
                .permissionId(UUID.fromString(rs.getString("permissionId")))
                .build();
    }
}
