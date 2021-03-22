package com.example.inklow.dao;

import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.ReportInquiryDetails;

import java.util.List;

public interface ReportInquiryDetailsDao {
    List<ReportInquiryDetails> getListOfReportInquiryDetails();

    List<ReportInquiryDetails> getReportInquiryDetailsById(ReportInquiryDetails reportInquiryDetails);

    ReportInquiryDetails addReportInquiryDetails(ReportInquiryDetails reportInquiryDetails);
    ReportInquiryDetails removeReportInquiryDetails(ReportInquiryDetails reportInquiryDetails);

    Boolean removeAllReportInquiryDetails();
}
