package com.example.inklow.serviceImp;

import com.example.inklow.dao.QuestionCategoryDao;
import com.example.inklow.entities.QuestionCategory;
import com.example.inklow.service.QuestionCategoryService;

import java.util.List;

public class QuestionCategoryServiceImp implements QuestionCategoryService {
    private final QuestionCategoryDao questionCategoryDao;

    public QuestionCategoryServiceImp(QuestionCategoryDao questionCategoryDao) {
        this.questionCategoryDao = questionCategoryDao;
    }

    @Override
    public List<QuestionCategory> getListOfCategoryService() {
        List<QuestionCategory> listOfQuestionCategory = questionCategoryDao.getListOfQuestionCategory();

        return listOfQuestionCategory;
    }

    @Override
    public QuestionCategory handleQuestionCategoryRegistration(QuestionCategory questionCategory) {
        QuestionCategory temp = questionCategoryDao.addQuestionCategory(questionCategory);

        return temp;
    }

    @Override
    public QuestionCategory findQuestionCategoryByName(String name) {
        QuestionCategory questionCategory = questionCategoryDao.getQuestionCategoryByName(name);

        return questionCategory;
    }

    @Override
    public int questionCategoryCount() {
        List<QuestionCategory> listOfQuestionCategory = questionCategoryDao.getListOfQuestionCategory();

        return listOfQuestionCategory.size();
    }
}
