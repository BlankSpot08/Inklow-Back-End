package com.example.inklow.configuration;

import com.example.inklow.dao.InquiryCategoryDao;
import com.example.inklow.service.InquiryCategoryService;
import com.example.inklow.serviceImp.InquiryCategoryServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InquiryCategoryServiceConfig {
    private final InquiryCategoryDao inquiryCategoryDao;

    public InquiryCategoryServiceConfig(InquiryCategoryDao inquiryCategoryDao) {
        this.inquiryCategoryDao = inquiryCategoryDao;
    }

    @Bean
    public InquiryCategoryService inquiryCategoryService() {
        return new InquiryCategoryServiceImp(inquiryCategoryDao);
    }
}
