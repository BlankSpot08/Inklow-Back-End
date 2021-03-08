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
    public List<Question> getListOfQuestionFilteredBy(String filter) {
        
        List<Question> listOfQuestion = questionDao.getListOfQuestions();

        final String tempFilter = filter.toLowerCase();
        for (int i = 0; i < listOfQuestion.size(); i++) {
            final String question = listOfQuestion.get(i).getQuestion().toLowerCase();

            if (!question.contains(tempFilter)) {
                listOfQuestion.remove(i);
                i--;
            }
        }

        return listOfQuestion;
    }

    @Override
    public List<Question> getListOfQuestionCategorizedBy(String category) {
        List<Question> listOfQuestion = questionDao.getListOfQuestions();

        String tempCategory = category.toLowerCase();
        for (int i = 0; i < listOfQuestion.size(); i++) {
            final String question = listOfQuestion.get(i).getCategory().toLowerCase();

            if (!question.equals(tempCategory)) {
                listOfQuestion.remove(i);
                i--;
            }
        }

        return listOfQuestion;
    }

    @Override
    public List<Question> getListOfFAQ() {
        List<Question> listOfQuestion = questionDao.getListOfQuestions();

        return listOfQuestion.subList(0, 5);
    }

    @Override
    public Boolean handleAllQuestionDeletion() {
        return questionDao.removeAllQuestions();
    }
}