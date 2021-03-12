package com.example.inklow.configuration;

import com.example.inklow.dao.InquiryCategoryDao;
import com.example.inklow.dao.InquiryDao;
import com.example.inklow.daoImp.InquiryDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class InquiryDaoConfig {
    private final JdbcTemplate jdbcTemplate;
    private final InquiryCategoryDao inquiryCategoryDao;

    @Autowired
    public InquiryDaoConfig(JdbcTemplate jdbcTemplate, InquiryCategoryDao inquiryCategoryDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.inquiryCategoryDao = inquiryCategoryDao;
    }

    @Bean
    public InquiryDao inquiryDao() {
        return new InquiryDaoImp(jdbcTemplate, inquiryCategoryDao);
    }
}
