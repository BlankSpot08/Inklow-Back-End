package com.example.inklow.configuration;

import com.example.inklow.dao.ReportInquiryDetailsDao;
import com.example.inklow.dao.ReportInquiryReplyDao;
import com.example.inklow.daoImp.ReportInquiryDetailsDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ReportInquiryDetailsDaoConfig {
    private final JdbcTemplate jdbcTemplate;
    private final ReportInquiryReplyDao reportInquiryReplyDao;

    @Autowired
    public ReportInquiryDetailsDaoConfig(JdbcTemplate jdbcTemplate,
                                         ReportInquiryReplyDao reportInquiryReplyDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.reportInquiryReplyDao = reportInquiryReplyDao;
    }

    @Bean
    public ReportInquiryDetailsDao reportInquiryDetailsDao() {
        return new ReportInquiryDetailsDaoImp(jdbcTemplate, reportInquiryReplyDao);
    }
}
