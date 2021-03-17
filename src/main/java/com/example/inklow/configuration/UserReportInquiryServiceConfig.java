package com.example.inklow.configuration;

import com.example.inklow.dao.UserReportInquiryDao;
import com.example.inklow.service.UserReportInquiryService;
import com.example.inklow.serviceImp.UserReportInquiryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserReportInquiryServiceConfig {
    private final UserReportInquiryDao userReportInquiryDao;

    @Autowired
    public UserReportInquiryServiceConfig(UserReportInquiryDao userReportInquiryDao) {
        this.userReportInquiryDao = userReportInquiryDao;
    }

    @Bean
    public UserReportInquiryService userReportInquiryService() {
        return new UserReportInquiryServiceImp(userReportInquiryDao);
    }
}