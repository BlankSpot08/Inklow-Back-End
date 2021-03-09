package com.example.inklow.dao;

import com.example.inklow.entities.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getListOfQuestions();

    Question handleQuestionRegistration(Question question);

    Boolean removeAllQuestions();
}
