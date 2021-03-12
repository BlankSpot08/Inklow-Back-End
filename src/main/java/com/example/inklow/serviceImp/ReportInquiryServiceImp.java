package com.example.inklow.serviceImp;

import com.example.inklow.dao.ReportInquiryDao;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.service.ReportInquiryService;

import java.util.List;

public class ReportInquiryServiceImp implements ReportInquiryService {
    private final ReportInquiryDao reportInquiryDao;

    public ReportInquiryServiceImp(ReportInquiryDao reportInquiryDao) {
        this.reportInquiryDao = reportInquiryDao;
    }

    @Override
    public List<ReportInquiry> getListOfReportInquiry() {
        return null;
    }

    @Override
    public ReportInquiry getReportInquiryById(ReportInquiry reportInquiry) {
        return null;
    }

    @Override
    public ReportInquiry getReportInquiryByName(ReportInquiry reportInquiry) {
        return null;
    }

    @Override
    public ReportInquiry handleReportInquiryRegistration(ReportInquiry reportInquiry) {
        return null;
    }

    @Override
    public ReportInquiry handleReportInquiryDeletion(ReportInquiry reportInquiry) {
        return null;
    }

    @Override
    public Boolean handleAllReportInquiryDeletion() {
        return null;
    }

    @Override
    public int reportInquiryCount() {
        return 0;
    }
}
