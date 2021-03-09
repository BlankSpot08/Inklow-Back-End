package com.example.inklow.service;

import com.example.inklow.entities.Inquiry;

import java.util.List;

public interface InquiryService {
    List<Inquiry> getListOfInquiry();

    Inquiry handleInquiryRegistration();
    Inquiry handleInquiryDeletion();

    int inquiryCount();
}
