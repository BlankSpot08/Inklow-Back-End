package com.example.inklow.serviceImp;

import com.example.inklow.dao.CategoryQuestionDao;
import com.example.inklow.entities.CategoryQuestion;
import com.example.inklow.service.CategoryQuestionService;

import java.util.List;

public class CategoryQuestionServiceImp implements CategoryQuestionService {
    private final CategoryQuestionDao categoryQuestionDao;

    public CategoryQuestionServiceImp(CategoryQuestionDao categoryQuestionDao) {
        this.categoryQuestionDao = categoryQuestionDao;
    }

    @Override
    public List<CategoryQuestion> getListOfCategoryService() {
        List<CategoryQuestion> listOfCategoryQuestion = categoryQuestionDao.getListOfQuestionCategory();

        return listOfCategoryQuestion;
    }

    @Override
    public CategoryQuestion handleQuestionCategoryRegistration(CategoryQuestion categoryQuestion) {
        CategoryQuestion temp = categoryQuestionDao.addQuestionCategory(categoryQuestion);

        return temp;
    }

    @Override
    public CategoryQuestion findQuestionCategoryByName(String name) {
        CategoryQuestion categoryQuestion = categoryQuestionDao.getQuestionCategoryByName(name);

        return categoryQuestion;
    }

    @Override
    public int questionCategoryCount() {
        List<CategoryQuestion> listOfCategoryQuestion = categoryQuestionDao.getListOfQuestionCategory();

        return listOfCategoryQuestion.size();
    }
}
