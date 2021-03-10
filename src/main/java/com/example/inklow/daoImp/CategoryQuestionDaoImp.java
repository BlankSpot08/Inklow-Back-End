package com.example.inklow.daoImp;

import com.example.inklow.dao.CategoryQuestionDao;
import com.example.inklow.entities.CategoryQuestion;
import com.example.inklow.mapper.QuestionCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CategoryQuestionDaoImp implements CategoryQuestionDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryQuestionDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CategoryQuestion> getListOfQuestionCategory() {
        String query = "SELECT * FROM category_support";

        List<CategoryQuestion> listOfCategoryQuestion = jdbcTemplate.query(query, new QuestionCategoryMapper());

        return listOfCategoryQuestion;
    }

    @Override
    public CategoryQuestion getQuestionCategoryById(UUID id) {
        String query = "SELECT * FROM category_support WHERE id = ?";

        CategoryQuestion categoryQuestion = jdbcTemplate.queryForObject(query, new Object[] {id.toString()}, new QuestionCategoryMapper());

        return categoryQuestion;
    }

    @Override
    public CategoryQuestion getQuestionCategoryByName(String name) {
        String query = "SELECT * FROM category_support WHERE name = ?";

        CategoryQuestion categoryQuestion = jdbcTemplate.queryForObject(query, new Object[] { name }, new QuestionCategoryMapper());

        return categoryQuestion;
    }

    @Override
    public CategoryQuestion addQuestionCategory(CategoryQuestion categoryQuestion) {
        String query = "INSERT INTO category_support(name) VALUES(?)";

        int statusCode = jdbcTemplate.update(query, categoryQuestion.getName());

        if (statusCode == 0) {
            return null;
        }

        return categoryQuestion;
    }
}
