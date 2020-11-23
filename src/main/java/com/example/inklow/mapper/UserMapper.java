package com.example.inklow.mapper;

import com.example.inklow.builder.UserBuilder;
import com.example.inklow.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public final class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserBuilder(UUID.fromString(rs.getString("id")))
                .firstName(rs.getString("firstName"))
                .lastName(rs.getString("lastName"))
                .gender(rs.getString("gender"))
                .birthDate(rs.getDate("birthDate"))
                .username(rs.getString("username"))
                .password(rs.getString("password"))
                .email(rs.getString("email"))
                .phoneNumber(rs.getString("phoneNumber"))
                .build();
    }
}
