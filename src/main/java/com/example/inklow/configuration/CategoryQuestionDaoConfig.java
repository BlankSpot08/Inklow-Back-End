package com.example.inklow.configuration;

import com.example.inklow.dao.CategoryQuestionDao;
import com.example.inklow.daoImp.CategoryQuestionDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class CategoryQuestionDaoConfig {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryQuestionDaoConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public CategoryQuestionDao categoryQuestionDao() {
        return new CategoryQuestionDaoImp(jdbcTemplate);
    }
}
