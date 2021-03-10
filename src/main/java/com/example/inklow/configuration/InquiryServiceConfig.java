package com.example.inklow.configuration;

import com.example.inklow.dao.InquiryDao;
import com.example.inklow.entities.Inquiry;
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
    public InquiryServiceConfig inquiryServiceConfig(InquiryDao inquiryDao) {
        return new InquiryServiceConfig(inquiryDao);
    }
}
