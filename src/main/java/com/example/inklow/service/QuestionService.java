package com.example.inklow.service;

import com.example.inklow.entities.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getListOfQuestion();
    List<Question> getListOfQuestionFilteredBy(String filter);
    List<Question> getListOfQuestionCategorizedBy(String category);
    List<Question> getListOfFAQ();

    Boolean handleAllQuestionDeletion();
}
