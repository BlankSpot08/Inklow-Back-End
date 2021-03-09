package com.example.inklow.daoImp;

import com.example.inklow.dao.QuestionCategoryDao;
import com.example.inklow.dao.QuestionDao;
import com.example.inklow.entities.Question;
import com.example.inklow.entities.QuestionCategory;
import com.example.inklow.mapper.QuestionCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class QuestionCategoryDaoImp implements QuestionCategoryDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionCategoryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<QuestionCategory> getListOfQuestionCategory() {
        String query = "SELECT * FROM support_category";

        List<QuestionCategory> listOfQuestionCategory = jdbcTemplate.query(query, new QuestionCategoryMapper());

        return listOfQuestionCategory;
    }

    @Override
    public QuestionCategory getQuestionCategoryById(UUID id) {
        String query = "SELECT * FROM support_category WHERE id = ?";

        QuestionCategory questionCategory = jdbcTemplate.queryForObject(query, new Object[] {id.toString()}, new QuestionCategoryMapper());

        return questionCategory;
    }

    @Override
    public QuestionCategory getQuestionCategoryByName(String name) {
        String query = "SELECT * FROM support_category WHERE name = ?";

        QuestionCategory questionCategory = jdbcTemplate.queryForObject(query, new Object[] { name }, new QuestionCategoryMapper());

        return questionCategory;
    }

    @Override
    public QuestionCategory addQuestionCategory(QuestionCategory questionCategory) {
        String query = "INSERT INTO support_category(name) VALUES(?)";

        int statusCode = jdbcTemplate.update(query, questionCategory.getName());

        if (statusCode == 0) {
            return null;
        }

        return questionCategory;
    }
}
