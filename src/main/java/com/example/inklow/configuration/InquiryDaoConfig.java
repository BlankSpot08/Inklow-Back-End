package com.example.inklow.configuration;

import com.example.inklow.dao.InquiryDao;
import com.example.inklow.daoImp.InquiryDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class InquiryDaoConfig {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InquiryDaoConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public InquiryDao inquiryDao() {
        return new InquiryDaoImp(jdbcTemplate);
    }
}
