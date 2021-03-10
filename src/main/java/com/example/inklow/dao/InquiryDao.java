package com.example.inklow.dao;

import com.example.inklow.entities.Inquiry;

import java.util.List;

public interface InquiryDao {
    List<Inquiry> listOfInquiries();

    Inquiry findInquiryById(Inquiry inquiry);

    Inquiry addInquiry(Inquiry inquiry);
    Inquiry deleteInquiry(Inquiry inquiry);
    Inquiry updateInquiry(Inquiry inquiry);

    Boolean removeAllInquiry();

}
