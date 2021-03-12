package com.example.inklow.service;

import com.example.inklow.configuration.InquiryCategoryDaoConfig;
import com.example.inklow.entities.CategoryInquiry;
import com.example.inklow.entities.Inquiry;
import com.example.inklow.entities.InquiryCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InquiryCategoryService {
    List<InquiryCategory> getListOfInquiryCategory();

    List<CategoryInquiry> getInquiryCategoriesById(Inquiry inquiry);

    InquiryCategory getInquiryCategoryById(InquiryCategory inquiryCategoryDaoConfig);

    InquiryCategory handleInquiryCategoryRegistration(InquiryCategory inquiryCategoryDaoConfig);
    InquiryCategory handleAllInquiryCategoryDeletion(InquiryCategory inquiryCategoryDaoConfig);

    Boolean handleAllInquiryCategoryDeletion();

    int inquiryCategoryCount();
}
