package com.example.inklow.mapper;

import com.example.inklow.entities.ReportInquiry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public final class ReportInquiryMapper implements RowMapper<ReportInquiry> {
    @Override
    public ReportInquiry mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ReportInquiry.Builder()
                .id(UUID.fromString(rs.getString("id")))
                .category(rs.getString("category"))
                .email(rs.getString("email"))
                .title(rs.getString("title"))
                .details(rs.getString("details"))
                .build();
    }
}
