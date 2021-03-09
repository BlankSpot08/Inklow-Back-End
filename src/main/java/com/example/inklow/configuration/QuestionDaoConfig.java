package com.example.inklow.configuration;

import com.example.inklow.dao.QuestionCategoryDao;
import com.example.inklow.dao.QuestionDao;
import com.example.inklow.daoImp.QuestionDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class QuestionDaoConfig {
    private final JdbcTemplate jdbcTemplate;
    private final QuestionCategoryDao questionCategoryDao;

    @Autowired
    public QuestionDaoConfig(final JdbcTemplate jdbcTemplate, final QuestionCategoryDao questionCategoryDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.questionCategoryDao = questionCategoryDao;
    }


    @Bean
    @Primary
    public QuestionDao questionDao() {
        return new QuestionDaoImp(jdbcTemplate, questionCategoryDao);
    }
}
