package com.example.inklow.service;

import com.example.inklow.configuration.InquiryCategoryDaoConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InquiryCategoryService {
    List<InquiryCategoryDaoConfig> getListOfInquiryCategory();

    List<InquiryCategoryDaoConfig> getInquiryCategoryById(InquiryCategoryDaoConfig inquiryCategoryDaoConfig);

    InquiryCategoryDaoConfig handleInquiryCategoryRegistration(InquiryCategoryDaoConfig inquiryCategoryDaoConfig);

    InquiryCategoryDaoConfig handleInquiryCategoryDeletion(InquiryCategoryDaoConfig inquiryCategoryDaoConfig);
    Boolean handleInquiryCategoryDeletion();

    int inquiryCategoryCount();
}
