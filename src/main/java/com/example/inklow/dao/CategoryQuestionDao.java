package com.example.inklow.dao;

import com.example.inklow.entities.CategoryQuestion;

import java.util.List;
import java.util.UUID;

public interface CategoryQuestionDao {
    List<CategoryQuestion> getListOfQuestionCategory();

    CategoryQuestion getQuestionCategoryById(UUID id);
    CategoryQuestion getQuestionCategoryByName(String name);

    CategoryQuestion addQuestionCategory(CategoryQuestion categoryQuestion);
}
