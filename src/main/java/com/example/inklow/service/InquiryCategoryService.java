package com.example.inklow.service;

import com.example.inklow.configuration.InquiryCategoryDaoConfig;
import com.example.inklow.entities.InquiryCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InquiryCategoryService {
    List<InquiryCategory> getListOfInquiryCategory();
    List<InquiryCategory> getInquiryCategoriesById(InquiryCategory inquiryCategoryDaoConfig);

    InquiryCategory getInquiryCategoryById(InquiryCategory inquiryCategoryDaoConfig);

    InquiryCategory handleInquiryCategoryRegistration(InquiryCategory inquiryCategoryDaoConfig);
    InquiryCategory handleAllInquiryCategoryDeletion(InquiryCategory inquiryCategoryDaoConfig);

    Boolean handleAllInquiryCategoryDeletion();

    int inquiryCategoryCount();
}
