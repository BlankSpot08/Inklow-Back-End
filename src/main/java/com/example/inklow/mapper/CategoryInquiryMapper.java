package com.example.inklow.mapper;

import com.example.inklow.entities.CategoryInquiry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CategoryInquiryMapper implements RowMapper<CategoryInquiry> {
    @Override
    public CategoryInquiry mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CategoryInquiry.Builder()
                .id(UUID.fromString(rs.getString("id")))
                .name(rs.getString("name"))
                .build();
    }
}
