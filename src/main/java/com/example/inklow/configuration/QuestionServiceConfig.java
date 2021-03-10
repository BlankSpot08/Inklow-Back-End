package com.example.inklow.configuration;

import com.example.inklow.dao.CategoryQuestionDao;
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
    private final CategoryQuestionDao categoryQuestionDao;

    @Autowired
    public QuestionServiceConfig(final QuestionDao questionDao, final CategoryQuestionDao categoryQuestionDao) {
        this.questionDao =  questionDao;
        this.categoryQuestionDao = categoryQuestionDao;
    }

    @Bean
    @Primary
    public QuestionService questionService() {
        return new QuestionServiceImp(questionDao, categoryQuestionDao);
    }

}
