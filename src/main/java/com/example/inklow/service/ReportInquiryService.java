package com.example.inklow.service;

import com.example.inklow.entities.ReportInquiry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportInquiryService {
    List<ReportInquiry> getListOfReportInquiry();

    ReportInquiry getReportInquiryById(ReportInquiry reportInquiry);
    ReportInquiry getReportInquiryByTitle(ReportInquiry reportInquiry);

    ReportInquiry handleReportInquiryRegistration(ReportInquiry reportInquiry);

    ReportInquiry handleReportInquiryDeletion(ReportInquiry reportInquiry);
    Boolean handleAllReportInquiryDeletion();

    int reportInquiryCount();
}
