package com.example.inklow.mapper;

import com.example.inklow.entities.CategoryQuestion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CategoryQuestionMapper implements RowMapper<CategoryQuestion> {
    @Override
    public CategoryQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CategoryQuestion.Builder()
                .id(UUID.fromString(rs.getString("id")))
                .name(rs.getString("name"))
                .build();
    }
}
