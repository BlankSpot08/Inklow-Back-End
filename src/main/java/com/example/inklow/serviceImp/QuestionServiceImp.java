package com.example.inklow.serviceImp;

import com.example.inklow.dao.QuestionDao;
import com.example.inklow.entities.Question;
import com.example.inklow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

    private final QuestionDao questionDao;

    @Autowired
    public QuestionServiceImp(final QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getListOfQuestion() {
        return questionDao.getListOfQuestions();
    }

    @Override
    public Boolean handleAllQuestionDeletion() {
        return questionDao.removeAllQuestions();
    }
}
