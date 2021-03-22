package com.example.inklow.configuration;

import com.example.inklow.dao.ReportInquiryDetailsDao;
import com.example.inklow.service.ReportInquiryDetailsService;
import com.example.inklow.serviceImp.ReportInquiryDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReportInquiryDetailsServiceConfig {
    private final ReportInquiryDetailsDao reportInquiryDetailsDao;

    @Autowired
    public ReportInquiryDetailsServiceConfig(ReportInquiryDetailsDao reportInquiryDetailsDao) {
        this.reportInquiryDetailsDao = reportInquiryDetailsDao;
    }

    @Bean
    public ReportInquiryDetailsService reportInquiryDetailsService() {
        return new ReportInquiryDetailsServiceImp(reportInquiryDetailsDao);
    }
}
