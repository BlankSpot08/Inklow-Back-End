package com.example.inklow.mapper;

import com.example.inklow.entities.QuestionCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class QuestionCategoryMapper implements RowMapper<QuestionCategory> {
    @Override
    public QuestionCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new QuestionCategory.Builder()
                .id(UUID.fromString(rs.getString("id")))
                .name(rs.getString("name"))
                .build();
    }
}
