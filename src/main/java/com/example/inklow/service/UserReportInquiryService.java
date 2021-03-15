package com.example.inklow.service;

import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.UserRole;

import java.util.List;
import java.util.UUID;

public interface UserReportInquiryService {
    List<ReportInquiry> getListOfReportInquiry();

    List<ReportInquiry> getReportInquiryById(ReportInquiry reportInquiry);

    ReportInquiry handleReportInquiryRegistration(ReportInquiry reportInquiry);

    ReportInquiry handleReportInquiryDeletion(ReportInquiry reportInquiry);
    Boolean handleAllReportInquiryDeletion();

    int reportInquiryCount();
}
