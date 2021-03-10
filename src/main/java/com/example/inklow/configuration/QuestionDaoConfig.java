package com.example.inklow.configuration;

import com.example.inklow.dao.CategoryQuestionDao;
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
    private final CategoryQuestionDao categoryQuestionDao;

    @Autowired
    public QuestionDaoConfig(final JdbcTemplate jdbcTemplate, final CategoryQuestionDao categoryQuestionDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.categoryQuestionDao = categoryQuestionDao;
    }


    @Bean
    @Primary
    public QuestionDao questionDao() {
        return new QuestionDaoImp(jdbcTemplate, categoryQuestionDao);
    }
}
