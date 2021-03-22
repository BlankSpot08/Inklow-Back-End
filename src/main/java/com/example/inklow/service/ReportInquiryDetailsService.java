package com.example.inklow.service;

import com.example.inklow.entities.ReportInquiryDetails;

import java.util.List;

public interface ReportInquiryDetailsService {
    List<ReportInquiryDetails> getListOfReportInquiryDetails();

    List<ReportInquiryDetails> getReportInquiryDetailsById(ReportInquiryDetails reportInquiryDetails);

    ReportInquiryDetails handleReportInquiryDetailsRegistration(ReportInquiryDetails reportInquiryDetails);

    ReportInquiryDetails handleReportInquiryDetailsDeletion(ReportInquiryDetails reportInquiryDetails);

    int reportInquiryDetailsCount();
}
