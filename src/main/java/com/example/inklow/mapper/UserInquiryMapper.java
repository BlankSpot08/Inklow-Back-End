package com.example.inklow.mapper;

import com.example.inklow.entities.UserInquiry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public final class UserInquiryMapper implements RowMapper<UserInquiry> {
    @Override
    public UserInquiry mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserInquiry(UUID.fromString(rs.getString("userId")), UUID.fromString(rs.getString("reportInquiryId")));
    }
}
