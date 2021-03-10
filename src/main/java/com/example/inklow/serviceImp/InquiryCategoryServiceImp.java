package com.example.inklow.serviceImp;

import com.example.inklow.configuration.InquiryCategoryDaoConfig;
import com.example.inklow.dao.InquiryCategoryDao;
import com.example.inklow.entities.InquiryCategory;
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
    public List<InquiryCategory> getListOfInquiryCategory() {
        List<InquiryCategory> listOfInquiryCategory = inquiryCategoryDao.getListOfInquiryCategory();

        return listOfInquiryCategory;
    }

    @Override
    public List<InquiryCategory> getInquiryCategoriesById(InquiryCategory inquiryCategory) {
        List<InquiryCategory> listOfInquiryCategory = inquiryCategoryDao.getInquiryCategoriesById(inquiryCategory);

        return listOfInquiryCategory;
    }

    @Override
    public InquiryCategory getInquiryCategoryById(InquiryCategory inquiryCategoryDaoConfig) {
        return null;
    }

    @Override
    public InquiryCategory handleInquiryCategoryRegistration(InquiryCategory inquiryCategory) {
        InquiryCategory temp = inquiryCategoryDao.addInquiryCategory(inquiryCategory);

        return temp;
    }

    @Override
    public InquiryCategory handleAllInquiryCategoryDeletion(InquiryCategory inquiryCategory) {
        InquiryCategory temp = inquiryCategoryDao.removeInquiryCategory(inquiryCategory);

        return temp;
    }

    @Override
    public Boolean handleAllInquiryCategoryDeletion() {
        Boolean temp = inquiryCategoryDao.removeAllInquiryCategory();

        return temp;
    }

    @Override
    public int inquiryCategoryCount() {
        List<InquiryCategory> listOfInquiryCategory = inquiryCategoryDao.getListOfInquiryCategory();

        return listOfInquiryCategory.size();
    }
}
