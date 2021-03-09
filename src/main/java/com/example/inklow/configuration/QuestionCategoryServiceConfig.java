package com.example.inklow.configuration;

import com.example.inklow.dao.QuestionCategoryDao;
import com.example.inklow.service.QuestionCategoryService;
import com.example.inklow.serviceImp.QuestionCategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionCategoryServiceConfig {
    private final QuestionCategoryDao questionCategoryDao;

    @Autowired
    public QuestionCategoryServiceConfig(QuestionCategoryDao questionCategoryDao) {
        this.questionCategoryDao = questionCategoryDao;
    }

    @Bean()
    public QuestionCategoryService questionCategoryService() {
        return new QuestionCategoryServiceImp(questionCategoryDao);
    }
}
