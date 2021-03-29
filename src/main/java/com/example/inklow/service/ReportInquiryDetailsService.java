package com.example.inklow.service;

import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.ReportInquiryDetails;

import java.util.List;

public interface ReportInquiryDetailsService {
    List<ReportInquiryDetails> getListOfReportInquiryDetails();

    List<ReportInquiryDetails> getReportInquiryDetailsById(ReportInquiry reportInquiry);

    ReportInquiryDetails handleReportInquiryDetailsRegistration(ReportInquiryDetails reportInquiryDetails);
    ReportInquiryDetails handleReportInquiryDetailsCancellation(ReportInquiryDetails reportInquiryDetails);

    ReportInquiryDetails handleReportInquiryDetailsDeletion(ReportInquiryDetails reportInquiryDetails);

    int reportInquiryDetailsCount();
}
