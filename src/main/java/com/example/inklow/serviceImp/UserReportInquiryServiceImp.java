package com.example.inklow.serviceImp;

import com.example.inklow.dao.UserReportInquiryDao;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.UserRole;
import com.example.inklow.service.UserReportInquiryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class UserReportInquiryServiceImp implements UserReportInquiryService {
    private final UserReportInquiryDao userReportInquiryDao;

    @Autowired
    public UserReportInquiryServiceImp(UserReportInquiryDao userReportInquiryDao) {
        this.userReportInquiryDao = userReportInquiryDao;
    }

    @Override
    public List<ReportInquiry> getListOfReportInquiry() {
        List<ReportInquiry> listOfReportInquiry = userReportInquiryDao.getListOfUserReportInquiries();

        return listOfReportInquiry;
    }

    @Override
    public List<ReportInquiry> getReportInquiryById(ReportInquiry reportInquiry) {
        List<ReportInquiry> temp = userReportInquiryDao.getUserReportInquiriesById(reportInquiry);

        return temp;
    }

    @Override
    public ReportInquiry handleReportInquiryRegistration(ReportInquiry reportInquiry) {
        ReportInquiry temp = userReportInquiryDao.addReportInquiry(reportInquiry);

        return temp;
    }

    @Override
    public ReportInquiry handleReportInquiryDeletion(ReportInquiry reportInquiry) {
        ReportInquiry temp = userReportInquiryDao.removeReportInquiry(reportInquiry);

        return temp;
    }

    @Override
    public Boolean handleAllReportInquiryDeletion() {
        Boolean temp = userReportInquiryDao.removeAllReportInquiry();

        return temp;
    }

    @Override
    public int reportInquiryCount() {
        List<ReportInquiry> listOfReportInquiry = userReportInquiryDao.getListOfUserReportInquiries();

        return listOfReportInquiry.size();
    }
}
