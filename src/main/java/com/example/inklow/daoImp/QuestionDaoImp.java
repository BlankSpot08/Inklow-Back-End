package com.example.inklow.daoImp;

import com.example.inklow.dao.QuestionDao;
import com.example.inklow.entities.Question;
import com.example.inklow.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDaoImp implements QuestionDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDaoImp(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Question> getListOfQuestions() {
        String query = "SELECT * FROM support_questions";

        List<Question> questions = jdbcTemplate.query(query, new QuestionMapper());

        return questions;
    }

    @Override
    public Boolean removeAllQuestions() {
        String query = "DELETE FROM support_questions";

        int statusCode = jdbcTemplate.update(query);

        if (statusCode == 0) {
            return null;
        }

        return true;
    }
}
