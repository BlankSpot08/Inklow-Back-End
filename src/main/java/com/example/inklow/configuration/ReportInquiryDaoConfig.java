package com.example.inklow.configuration;

import com.example.inklow.dao.ReportInquiryDao;
import com.example.inklow.dao.ReportInquiryDetailsDao;
import com.example.inklow.daoImp.ReportInquiryDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.JavaBean;

@Configuration
public class ReportInquiryDaoConfig {
    private final JdbcTemplate jdbcTemplate;
    private final ReportInquiryDetailsDao reportInquiryDetailsDao;

    @Autowired
    public ReportInquiryDaoConfig(JdbcTemplate jdbcTemplate,
                                  ReportInquiryDetailsDao reportInquiryDetailsDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.reportInquiryDetailsDao = reportInquiryDetailsDao;
    }

    @Bean
    public ReportInquiryDao reportInquiryDao() {
        return new ReportInquiryDaoImp(jdbcTemplate, reportInquiryDetailsDao);
    }
}
