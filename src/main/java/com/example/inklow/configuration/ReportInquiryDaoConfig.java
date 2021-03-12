package com.example.inklow.configuration;

import com.example.inklow.dao.ReportInquiryDao;
import com.example.inklow.daoImp.ReportInquiryDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.JavaBean;

@Configuration
public class ReportInquiryDaoConfig {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReportInquiryDaoConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public ReportInquiryDao reportInquiryDao() {
        return new ReportInquiryDaoImp(jdbcTemplate);
    }
}
