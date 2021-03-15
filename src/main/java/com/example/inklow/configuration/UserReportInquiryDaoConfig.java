package com.example.inklow.configuration;

import com.example.inklow.dao.ReportInquiryDao;
import com.example.inklow.dao.UserReportInquiryDao;
import com.example.inklow.daoImp.UserReportInquiryDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UserReportInquiryDaoConfig {
    private final JdbcTemplate jdbcTemplate;
    private final ReportInquiryDao reportInquiryDao;

    @Autowired
    public UserReportInquiryDaoConfig(JdbcTemplate jdbcTemplate, ReportInquiryDao reportInquiryDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.reportInquiryDao = reportInquiryDao;
    }

    @Bean
    public UserReportInquiryDao userReportInquiryDao() {
        return new UserReportInquiryDaoImp(jdbcTemplate, reportInquiryDao);
    }

}
