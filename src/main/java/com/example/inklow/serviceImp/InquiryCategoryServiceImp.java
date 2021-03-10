package com.example.inklow.serviceImp;

import com.example.inklow.configuration.InquiryCategoryDaoConfig;
import com.example.inklow.dao.InquiryCategoryDao;
import com.example.inklow.service.InquiryCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InquiryCategoryServiceImp implements InquiryCategoryService {
    private final InquiryCategoryDao inquiryCategoryDao;

    @Autowired
    public InquiryCategoryServiceImp(InquiryCategoryDao inquiryCategoryDao) {
        this.inquiryCategoryDao = inquiryCategoryDao;
    }

    @Override
    public List<InquiryCategoryDaoConfig> getListOfInquiryCategory() {
        return null;
    }

    @Override
    public List<InquiryCategoryDaoConfig> getInquiryCategoryById(InquiryCategoryDaoConfig inquiryCategoryDaoConfig) {
        return null;
    }

    @Override
    public InquiryCategoryDaoConfig handleInquiryCategoryRegistration(InquiryCategoryDaoConfig inquiryCategoryDaoConfig) {
        return null;
    }

    @Override
    public InquiryCategoryDaoConfig handleInquiryCategoryDeletion(InquiryCategoryDaoConfig inquiryCategoryDaoConfig) {
        return null;
    }

    @Override
    public Boolean handleInquiryCategoryDeletion() {
        return null;
    }

    @Override
    public int inquiryCategoryCount() {
        return 0;
    }
}
