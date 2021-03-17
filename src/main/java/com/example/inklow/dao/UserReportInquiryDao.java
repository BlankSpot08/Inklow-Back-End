package com.example.inklow.dao;

import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.User;
import com.example.inklow.entities.UserReportInquiry;

import java.util.List;

public interface UserReportInquiryDao {
    List<UserReportInquiry> getListOfUserReportInquiries();

    List<ReportInquiry> getUserReportInquiriesById(User user);

    UserReportInquiry addUserReportInquiry(UserReportInquiry userReportInquiry);

    UserReportInquiry removeUserReportInquiry(UserReportInquiry userReportInquiry);
    Boolean removeUserAllReportInquiry();
}
