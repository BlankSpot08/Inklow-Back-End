package com.example.inklow.configuration;

import com.example.inklow.dao.ReportInquiryReplyDao;
import com.example.inklow.service.ReportInquiryReplyService;
import com.example.inklow.serviceImp.ReportInquiryReplyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReportInquiryReplyServiceConfig {
    private final ReportInquiryReplyDao reportInquiryReplyDao;

    @Autowired
    public ReportInquiryReplyServiceConfig(ReportInquiryReplyDao reportInquiryReplyDao) {
        this.reportInquiryReplyDao = reportInquiryReplyDao;
    }

    @Bean
    public ReportInquiryReplyService reportInquiryReplyService() {
        return new ReportInquiryReplyServiceImp(reportInquiryReplyDao);
    }
}
