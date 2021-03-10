package com.example.inklow.serviceImp;

import com.example.inklow.dao.CategoryInquiryDao;
import com.example.inklow.entities.CategoryInquiry;
import com.example.inklow.entities.CategoryQuestion;
import com.example.inklow.service.CategoryInquiryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryInquiryServiceImp implements CategoryInquiryService {
    private final CategoryInquiryDao categoryInquiryDao;

    public CategoryInquiryServiceImp(CategoryInquiryDao categoryInquiryDao) {
        this.categoryInquiryDao = categoryInquiryDao;
    }

    @Override
    public List<CategoryInquiry> getListOfCategoryService() {
        List<CategoryInquiry> listOfCategoryInquiry  = categoryInquiryDao.getListOfCategoryInquiry();

        return listOfCategoryInquiry;
    }

    @Override
    public CategoryInquiry handleQuestionCategoryRegistration(CategoryInquiry categoryInquiry) {
        CategoryInquiry temp = categoryInquiryDao.addCategoryInquiry(categoryInquiry);

        return temp;
    }

    @Override
    public CategoryInquiry findQuestionCategoryByName(CategoryInquiry categoryInquiry) {
        CategoryInquiry temp = categoryInquiryDao.getCategoryInquiryByName(categoryInquiry);

        return temp;
    }

    @Override
    public int questionCategoryCount() {
        List<CategoryInquiry> listOfCategoryInquiry  = categoryInquiryDao.getListOfCategoryInquiry();

        return listOfCategoryInquiry.size();
    }
}
