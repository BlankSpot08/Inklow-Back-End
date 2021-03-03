package com.example.inklow.mapper;

import com.example.inklow.entities.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public final class QuestionMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Question.Builder()
                .id(UUID.fromString(rs.getString("id")))
                .question(rs.getString("question"))
                .answer(rs.getString("answer"))
                .build();
    }
}
