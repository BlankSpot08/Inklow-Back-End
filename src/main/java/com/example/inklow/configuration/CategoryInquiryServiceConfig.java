package com.example.inklow.configuration;

import com.example.inklow.dao.CategoryInquiryDao;
import com.example.inklow.service.CategoryInquiryService;
import com.example.inklow.serviceImp.CategoryInquiryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryInquiryServiceConfig {
    private final CategoryInquiryDao categoryInquiryDao;

    @Autowired
    public CategoryInquiryServiceConfig(CategoryInquiryDao categoryInquiryDao) {
        this.categoryInquiryDao = categoryInquiryDao;
    }

    @Bean
    public CategoryInquiryService categoryInquiryService() {
        return new CategoryInquiryServiceImp(categoryInquiryDao);
    }
}
