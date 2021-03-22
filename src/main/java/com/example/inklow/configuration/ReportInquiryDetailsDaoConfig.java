package com.example.inklow.configuration;

import com.example.inklow.dao.ReportInquiryDetailsDao;
import com.example.inklow.daoImp.ReportInquiryDetailsDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ReportInquiryDetailsDaoConfig {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReportInquiryDetailsDaoConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public ReportInquiryDetailsDao reportInquiryDetailsDao() {
        return new ReportInquiryDetailsDaoImp(jdbcTemplate);
    }
}
