package com.example.inklow.service;

import com.example.inklow.entities.CategoryInquiry;

import java.util.List;

public interface CategoryInquiryService {
    List<CategoryInquiry> getListOfCategoryService();

    CategoryInquiry handleQuestionCategoryRegistration(CategoryInquiry categoryInquiry);

    CategoryInquiry findQuestionCategoryByName(CategoryInquiry categoryInquiry);

    int questionCategoryCount();
}
