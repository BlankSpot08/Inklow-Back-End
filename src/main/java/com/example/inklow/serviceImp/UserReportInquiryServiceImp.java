package com.example.inklow.serviceImp;

import com.example.inklow.dao.UserReportInquiryDao;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.User;
import com.example.inklow.entities.UserReportInquiry;
import com.example.inklow.service.UserReportInquiryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserReportInquiryServiceImp implements UserReportInquiryService {
    private final UserReportInquiryDao userReportInquiryDao;

    @Autowired
    public UserReportInquiryServiceImp(UserReportInquiryDao userReportInquiryDao) {
        this.userReportInquiryDao = userReportInquiryDao;
    }

    @Override
    public List<UserReportInquiry> getListOfUserReportInquiries() {
        List<UserReportInquiry> listOfReportInquiry = userReportInquiryDao.getListOfUserReportInquiries();

        return listOfReportInquiry;
    }

    @Override
    public List<ReportInquiry> getUserReportInquiriesById(User user) {
        List<ReportInquiry> temp = userReportInquiryDao.getUserReportInquiriesById(user);

        return temp;
    }

    @Override
    public UserReportInquiry handleUserReportInquiryRegistration(UserReportInquiry userReportInquiry) {
        UserReportInquiry temp = userReportInquiryDao.addUserReportInquiry(userReportInquiry);

        return temp;
    }

    @Override
    public UserReportInquiry handleUserReportInquiryDeletion(UserReportInquiry userReportInquiry) {
        UserReportInquiry temp = userReportInquiryDao.removeUserReportInquiry(userReportInquiry);

        return temp;
    }

    @Override
    public Boolean handleAllUserReportInquiryDeletion() {
        Boolean temp = userReportInquiryDao.removeUserAllReportInquiry();

        return temp;
    }

    @Override
    public int reportInquiryCount() {
        List<UserReportInquiry> listOfReportInquiry = userReportInquiryDao.getListOfUserReportInquiries();

        return listOfReportInquiry.size();
    }
}
