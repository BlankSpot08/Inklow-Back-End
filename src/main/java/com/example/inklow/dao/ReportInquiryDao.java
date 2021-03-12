package com.example.inklow.dao;

import com.example.inklow.entities.ReportInquiry;

import java.util.List;

public interface ReportInquiryDao {
    List<ReportInquiry> getListOfReportInquiry();

    ReportInquiry getReportInquiryById(ReportInquiry reportInquiry);
    ReportInquiry getReportInquiryByName(ReportInquiry reportInquiry);

    ReportInquiry addReportInquiry(ReportInquiry reportInquiry);
    ReportInquiry removeReportInquiry(ReportInquiry reportInquiry);

    Boolean removeAllReportInquiry();
}
