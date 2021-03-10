package com.example.inklow.daoImp;

import com.example.inklow.dao.CategoryQuestionDao;
import com.example.inklow.entities.CategoryQuestion;
import com.example.inklow.mapper.CategoryQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryQuestionDaoImp implements CategoryQuestionDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryQuestionDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CategoryQuestion> getListOfCategoryQuestion() {
        String query = "SELECT * FROM category_support";

        List<CategoryQuestion> listOfCategoryQuestion = jdbcTemplate.query(query, new CategoryQuestionMapper());

        return listOfCategoryQuestion;
    }

    @Override
    public CategoryQuestion getCategoryQuestionById(CategoryQuestion categoryQuestion) {
        String query = "SELECT * FROM category_support WHERE id = ?";

        CategoryQuestion temp = jdbcTemplate.queryForObject(query, new Object[] { categoryQuestion.getId() }, new CategoryQuestionMapper());

        return temp;
    }

    @Override
    public CategoryQuestion getCategoryQuestionByName(CategoryQuestion categoryQuestion) {
        String query = "SELECT * FROM category_support WHERE name = ?";

        CategoryQuestion temp = jdbcTemplate.queryForObject(query, new Object[] { categoryQuestion.getName() }, new CategoryQuestionMapper());

        return temp;
    }

    @Override
    public CategoryQuestion addCategoryQuestion(CategoryQuestion categoryQuestion) {
        String query = "INSERT INTO category_support(name) VALUES(?)";

        int statusCode = jdbcTemplate.update(query, categoryQuestion.getName());

        if (statusCode == 0) {
            return null;
        }

        return categoryQuestion;
    }
}
