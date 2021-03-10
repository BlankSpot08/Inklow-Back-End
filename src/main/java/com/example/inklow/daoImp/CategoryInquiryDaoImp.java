package com.example.inklow.daoImp;

import com.example.inklow.dao.CategoryInquiryDao;
import com.example.inklow.entities.CategoryInquiry;
import com.example.inklow.entities.CategoryQuestion;
import com.example.inklow.mapper.CategoryInquiryMapper;
import com.example.inklow.mapper.CategoryQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryInquiryDaoImp implements CategoryInquiryDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryInquiryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CategoryInquiry> getListOfCategoryInquiry() {
        String query = "SELECT * FROM category_inquiry";

        List<CategoryInquiry> listOfCategoryQuestion = jdbcTemplate.query(query, new CategoryInquiryMapper());

        return listOfCategoryQuestion;
    }

    @Override
    public CategoryInquiry getCategoryInquiryById(CategoryInquiry categoryInquiry) {
        String query = "SELECT * FROM category_inquiry";

        CategoryInquiry temp = jdbcTemplate.queryForObject(query, new Object[] { categoryInquiry.getId() }, new CategoryInquiryMapper());

        return temp;
    }

    @Override
    public CategoryInquiry getCategoryInquiryByName(CategoryInquiry categoryInquiry) {
        String query = "SELECT * FROM category_inquiry WHERE name = ?";

        CategoryInquiry temp = jdbcTemplate.queryForObject(query, new Object[] { categoryInquiry.getName() }, new CategoryInquiryMapper());

        return temp;
    }

    @Override
    public CategoryInquiry addCategoryInquiry(CategoryInquiry categoryInquiry) {
        String query = "INSERT INTO category_inquiry(name) VALUES(?)";

        int statusCode = jdbcTemplate.update(query, categoryInquiry.getName());

        if (statusCode == 0) {
            return null;
        }

        return categoryInquiry;
    }
}
