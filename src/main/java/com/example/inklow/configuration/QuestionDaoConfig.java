package com.example.inklow.configuration;

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

    @Autowired
    public QuestionDaoConfig(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Bean
    @Primary
    public QuestionDao questionDao() {
        return new QuestionDaoImp(jdbcTemplate);
    }
}
