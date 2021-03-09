package com.example.inklow.service;

import com.example.inklow.entities.QuestionCategory;

import java.util.List;

public interface QuestionCategoryService {
    List<QuestionCategory> getListOfCategoryService();

    QuestionCategory handleQuestionCategoryRegistration(QuestionCategory questionCategory);

    QuestionCategory findQuestionCategoryByName(String name);

    int questionCategoryCount();
}
