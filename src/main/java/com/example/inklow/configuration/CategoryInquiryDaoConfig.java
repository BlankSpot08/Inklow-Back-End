package com.example.inklow.configuration;

import com.example.inklow.dao.CategoryInquiryDao;
import com.example.inklow.daoImp.CategoryInquiryDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class CategoryInquiryDaoConfig {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryInquiryDaoConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public CategoryInquiryDao categoryInquiryDao() {
        return new CategoryInquiryDaoImp(jdbcTemplate);
    }
}
