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
        List<Inquiry> listOfInquiry = inquiryDao.listOfInquiries();

        return listOfInquiry;
    }

    @Override
    public Inquiry handleInquiryRegistration(Inquiry inquiry) {
        Inquiry temp = inquiryDao.addInquiry(inquiry);

        return temp;
    }

    @Override
    public Inquiry handleInquiryDeletion(Inquiry inquiry) {
        Inquiry temp = inquiryDao.deleteInquiry(inquiry);

        return temp;
    }

    @Override
    public int inquiryCount() {
        List<Inquiry> listOfInquiry = inquiryDao.listOfInquiries();

        return listOfInquiry.size();
    }
}
