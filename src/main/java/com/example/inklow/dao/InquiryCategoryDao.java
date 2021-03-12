package com.example.inklow.dao;

import com.example.inklow.entities.*;

import java.util.List;
import java.util.UUID;

public interface InquiryCategoryDao {
    List<InquiryCategory> getListOfInquiryCategory();
    List<CategoryInquiry> getInquiryCategoriesById(Inquiry inquiry);
    CategoryInquiry getInquiryCategoryById(InquiryCategory inquiryCategory);

    InquiryCategory addInquiryCategory(InquiryCategory inquiryCategory);
    InquiryCategory removeInquiryCategory(InquiryCategory inquiryCategory);

    Boolean removeAllInquiryCategory();
}
