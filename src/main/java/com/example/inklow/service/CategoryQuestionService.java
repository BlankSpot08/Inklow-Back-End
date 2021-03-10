package com.example.inklow.service;

import com.example.inklow.entities.CategoryQuestion;

import java.util.List;

public interface CategoryQuestionService {
    List<CategoryQuestion> getListOfCategoryService();

    CategoryQuestion handleQuestionCategoryRegistration(CategoryQuestion categoryQuestion);

    CategoryQuestion findQuestionCategoryByName(CategoryQuestion categoryQuestion);

    int questionCategoryCount();
}
