package com.example.inklow.configuration;

import com.example.inklow.dao.QuestionCategoryDao;
import com.example.inklow.dao.QuestionDao;
import com.example.inklow.service.QuestionService;
import com.example.inklow.serviceImp.QuestionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class QuestionServiceConfig {
    private final QuestionDao questionDao;
    private final QuestionCategoryDao questionCategoryDao;

    @Autowired
    public QuestionServiceConfig(final QuestionDao questionDao, final QuestionCategoryDao questionCategoryDao) {
        this.questionDao =  questionDao;
        this.questionCategoryDao = questionCategoryDao;
    }

    @Bean
    @Primary
    public QuestionService questionService() {
        return new QuestionServiceImp(questionDao, questionCategoryDao);
    }

}
