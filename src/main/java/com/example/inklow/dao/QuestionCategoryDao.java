package com.example.inklow.dao;

import com.example.inklow.entities.QuestionCategory;

import java.util.List;
import java.util.UUID;

public interface QuestionCategoryDao {
    List<QuestionCategory> getListOfQuestionCategory();

    QuestionCategory getQuestionCategoryById(UUID id);
    QuestionCategory getQuestionCategoryByName(String name);

    QuestionCategory addQuestionCategory(QuestionCategory questionCategory);
}
