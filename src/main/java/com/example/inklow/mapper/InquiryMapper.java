package com.example.inklow.mapper;

import com.example.inklow.entities.Inquiry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public final class InquiryMapper implements RowMapper<Inquiry> {
    @Override
    public Inquiry mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Inquiry.Builder()
                .id(UUID.fromString(rs.getString("id")))
                .name(rs.getString("name"))
                .build();
    }
}
