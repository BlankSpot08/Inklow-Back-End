package com.example.inklow.dao;

import com.example.inklow.entities.CategoryInquiry;
import com.example.inklow.entities.CategoryQuestion;

import java.util.List;
import java.util.UUID;

public interface CategoryInquiryDao {
    List<CategoryInquiry> getListOfCategoryInquiry();

    CategoryInquiry getCategoryInquiryById(CategoryInquiry categoryInquiry);
    CategoryInquiry getCategoryInquiryByName(CategoryInquiry categoryInquiry);

    CategoryInquiry addCategoryInquiry(CategoryInquiry categoryInquiry);
}
