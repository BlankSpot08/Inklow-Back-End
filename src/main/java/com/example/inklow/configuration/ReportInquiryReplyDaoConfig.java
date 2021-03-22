package com.example.inklow.configuration;

import com.example.inklow.dao.ReportInquiryReplyDao;
import com.example.inklow.daoImp.ReportInquiryReplyDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ReportInquiryReplyDaoConfig {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReportInquiryReplyDaoConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public ReportInquiryReplyDao reportInquiryReplyDao() {
        return new ReportInquiryReplyDaoImp(jdbcTemplate);
    }
}
