package com.example.inklow.mapper;

import com.example.inklow.entities.UserReportInquiry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public final class UserInquiryMapper implements RowMapper<UserReportInquiry> {
    @Override
    public UserReportInquiry mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserReportInquiry(UUID.fromString(rs.getString("userId")), UUID.fromString(rs.getString("reportInquiryId")));
    }
}
