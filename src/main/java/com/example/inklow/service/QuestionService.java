package com.example.inklow.service;

import com.example.inklow.entities.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getListOfQuestion();

    Boolean handleAllQuestionDeletion();
}
