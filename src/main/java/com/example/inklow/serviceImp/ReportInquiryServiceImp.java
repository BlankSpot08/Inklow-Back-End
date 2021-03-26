package com.example.inklow.serviceImp;

import com.example.inklow.dao.ReportInquiryDao;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.User;
import com.example.inklow.service.ReportInquiryService;

import java.util.List;

public class ReportInquiryServiceImp implements ReportInquiryService {
    private final ReportInquiryDao reportInquiryDao;

    public ReportInquiryServiceImp(ReportInquiryDao reportInquiryDao) {
        this.reportInquiryDao = reportInquiryDao;
    }

    @Override
    public List<ReportInquiry> getListOfReportInquiry() {
        return reportInquiryDao.getListOfReportInquiry();
    }

    @Override
    public List<ReportInquiry> getUserListOfReportInquiry(User user) {
        List<ReportInquiry> listOfReportInquiry = reportInquiryDao.getUserListOfReportInquiry(user);

        return listOfReportInquiry;
    }

    @Override
    public ReportInquiry getReportInquiryById(ReportInquiry reportInquiry) {
        return reportInquiryDao.getReportInquiryById(reportInquiry);
    }

    @Override
    public ReportInquiry getReportInquiryByTitle(ReportInquiry reportInquiry) {
        return reportInquiryDao.getReportInquiryByTitle(reportInquiry);
    }

    @Override
    public ReportInquiry handleReportInquiryRegistration(ReportInquiry reportInquiry) {
        return reportInquiryDao.addReportInquiry(reportInquiry);
    }

    @Override
    public ReportInquiry handleReportInquiryDeletion(ReportInquiry reportInquiry) {
        return reportInquiryDao.removeReportInquiry(reportInquiry);
    }

    @Override
    public Boolean handleAllReportInquiryDeletion() {
        return reportInquiryDao.removeAllReportInquiry();
    }

    @Override
    public int reportInquiryCount() {
        List<ReportInquiry> listOfReportInquiry = reportInquiryDao.getListOfReportInquiry();

        return listOfReportInquiry.size();
    }
}