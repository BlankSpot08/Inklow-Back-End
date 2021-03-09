package com.example.inklow.configuration;

import com.example.inklow.dao.QuestionCategoryDao;
import com.example.inklow.daoImp.QuestionCategoryDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class QuestionCategoryDaoConfig {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionCategoryDaoConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean()
    public QuestionCategoryDao questionCategory() {
        return new QuestionCategoryDaoImp(jdbcTemplate);
    }
}
