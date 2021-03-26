package com.example.inklow.dao;

import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.User;

import java.util.List;

public interface ReportInquiryDao {
    List<ReportInquiry> getListOfReportInquiry();

    List<ReportInquiry> getUserListOfReportInquiry(User user);

    ReportInquiry getReportInquiryById(ReportInquiry reportInquiry);
    ReportInquiry getReportInquiryByTitle(ReportInquiry reportInquiry);

    ReportInquiry addReportInquiry(ReportInquiry reportInquiry);
    ReportInquiry removeReportInquiry(ReportInquiry reportInquiry);

    Boolean removeAllReportInquiry();
}
