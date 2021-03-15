package com.example.inklow.dao;

import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;
import com.example.inklow.entities.UserRole;

import java.util.List;
import java.util.UUID;

public interface UserReportInquiryDao {
    List<ReportInquiry> getListOfUserReportInquiries();

    List<ReportInquiry> getUserReportInquiriesById(ReportInquiry reportInquiry);

    ReportInquiry addReportInquiry(ReportInquiry reportInquiry);

    ReportInquiry removeReportInquiry(ReportInquiry reportInquiry);
    Boolean removeAllReportInquiry();
}
