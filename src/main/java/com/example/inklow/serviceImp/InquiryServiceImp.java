package com.example.inklow.serviceImp;

import com.example.inklow.dao.InquiryDao;
import com.example.inklow.entities.Inquiry;
import com.example.inklow.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InquiryServiceImp implements InquiryService {
    private final InquiryDao inquiryDao;

    @Autowired
    public InquiryServiceImp(InquiryDao inquiryDao) {
        this.inquiryDao = inquiryDao;
    }

    @Override
    public List<Inquiry> getListOfInquiry() {
        return null;
    }

    @Override
    public Inquiry handleInquiryRegistration() {
        return null;
    }

    @Override
    public Inquiry handleInquiryDeletion() {
        return null;
    }

    @Override
    public int inquiryCount() {
        return 0;
    }
}
