package com.example.inklow.configuration;

import com.example.inklow.dao.InquiryCategoryDao;
import com.example.inklow.daoImp.InquiryCategoryDaoImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class InquiryCategoryDaoConfig {
    private final JdbcTemplate jdbcTemplate;

    public InquiryCategoryDaoConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public InquiryCategoryDao inquiryCategoryDao() {
        return new InquiryCategoryDaoImp(jdbcTemplate);
    }
}
