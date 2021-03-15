package com.example.inklow.configuration;

import com.example.inklow.dao.UserReportInquiryDao;
import com.example.inklow.service.UserReportInquiryService;
import com.example.inklow.serviceImp.UserReportInquiryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class UserReportInquiryDaoServiceConfig {
    private final UserReportInquiryDao userReportInquiryDao;

    @Autowired
    public UserReportInquiryDaoServiceConfig(UserReportInquiryDao userReportInquiryDao) {
        this.userReportInquiryDao = userReportInquiryDao;
    }

    @Bean
    public UserReportInquiryService userReportInquiryService() {
        return new UserReportInquiryServiceImp(userReportInquiryDao);
    }
}