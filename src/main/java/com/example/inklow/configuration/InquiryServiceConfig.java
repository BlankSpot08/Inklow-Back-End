package com.example.inklow.configuration;

import com.example.inklow.dao.CategoryInquiryDao;
import com.example.inklow.dao.InquiryCategoryDao;
import com.example.inklow.dao.InquiryDao;
import com.example.inklow.entities.CategoryInquiry;
import com.example.inklow.entities.Inquiry;
import com.example.inklow.service.InquiryService;
import com.example.inklow.serviceImp.InquiryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InquiryServiceConfig {
    private final InquiryDao inquiryDao;

    @Autowired
    public InquiryServiceConfig(InquiryDao inquiryDao) {
        this.inquiryDao = inquiryDao;
    }

    @Bean
    public InquiryService inquiryService() {
        return new InquiryServiceImp(inquiryDao);
    }
}
