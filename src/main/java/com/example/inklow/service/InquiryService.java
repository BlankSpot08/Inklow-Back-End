package com.example.inklow.service;

import com.example.inklow.entities.Inquiry;

import java.util.List;

public interface InquiryService {
    List<Inquiry> getListOfInquiry();

    Inquiry getInquiryByName(Inquiry inquiry);
    Inquiry getInquiryById(Inquiry inquiry);

    Inquiry handleInquiryRegistration(Inquiry inquiry);
    Inquiry handleInquiryDeletion(Inquiry inquiry);

    int inquiryCount();
}
