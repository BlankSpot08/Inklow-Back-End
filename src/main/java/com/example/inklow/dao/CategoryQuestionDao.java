package com.example.inklow.dao;

import com.example.inklow.entities.CategoryQuestion;

import java.util.List;
import java.util.UUID;

public interface CategoryQuestionDao {
    List<CategoryQuestion> getListOfCategoryQuestion();

    CategoryQuestion getCategoryQuestionById(CategoryQuestion categoryQuestion);
    CategoryQuestion getCategoryQuestionByName(CategoryQuestion categoryQuestion);

    CategoryQuestion addCategoryQuestion(CategoryQuestion categoryQuestion);
}
