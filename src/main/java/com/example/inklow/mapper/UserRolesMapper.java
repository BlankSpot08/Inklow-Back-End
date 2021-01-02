package com.example.inklow.mapper;

import com.example.inklow.entities.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public final class UserRolesMapper implements RowMapper<UserRole> {
    @Override
    public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserRole.Builder()
                .userId(UUID.fromString(rs.getString("userId")))
                .roleId(UUID.fromString(rs.getString("roleId")))
                .build();
    }
}
