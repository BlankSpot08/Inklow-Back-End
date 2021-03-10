package com.example.inklow.configuration;

import com.example.inklow.dao.CategoryQuestionDao;
import com.example.inklow.service.CategoryQuestionService;
import com.example.inklow.serviceImp.CategoryQuestionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryQuestionServiceConfig {
    private final CategoryQuestionDao categoryQuestionDao;

    @Autowired
    public CategoryQuestionServiceConfig(CategoryQuestionDao categoryQuestionDao) {
        this.categoryQuestionDao = categoryQuestionDao;
    }

    @Bean
    public CategoryQuestionService categoryQuestionService() {
        return new CategoryQuestionServiceImp(categoryQuestionDao);
    }
}
