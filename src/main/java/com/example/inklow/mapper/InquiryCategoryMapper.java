package com.example.inklow.mapper;

import com.example.inklow.entities.InquiryCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public final class InquiryCategoryMapper implements RowMapper<InquiryCategory> {
    @Override
    public InquiryCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new InquiryCategory.Builder()
                .inquiryId(UUID.fromString(rs.getString("inquiryId")))
                .categoryId(UUID.fromString(rs.getString("inquiry_categoryId")))
                .build();
    }
}