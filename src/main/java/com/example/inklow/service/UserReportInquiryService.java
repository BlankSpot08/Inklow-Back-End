package com.example.inklow.service;

import com.example.inklow.entities.*;

import java.util.List;
import java.util.UUID;

public interface UserReportInquiryService {
    List<ReportInquiry> getListOfUserReportInquiries();

    List<ReportInquiry> getUserReportInquiriesById(User user);

    UserReportInquiry handleUserReportInquiryRegistration(UserReportInquiry userReportInquiry);

    UserReportInquiry handleUserReportInquiryDeletion(UserReportInquiry userReportInquiry);
    Boolean handleAllUserReportInquiryDeletion();

    int reportInquiryCount();
}
