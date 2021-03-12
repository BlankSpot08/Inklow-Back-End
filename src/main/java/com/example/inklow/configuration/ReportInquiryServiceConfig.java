package com.example.inklow.configuration;

import com.example.inklow.dao.ReportInquiryDao;
import com.example.inklow.service.ReportInquiryService;
import com.example.inklow.serviceImp.ReportInquiryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReportInquiryServiceConfig {
    private final ReportInquiryDao reportInquiryDao;

    @Autowired
    public ReportInquiryServiceConfig(ReportInquiryDao reportInquiryDao) {
        this.reportInquiryDao = reportInquiryDao;
    }

    @Bean
    public ReportInquiryService reportInquiryService() {
        return new ReportInquiryServiceImp(reportInquiryDao);
    }
}
