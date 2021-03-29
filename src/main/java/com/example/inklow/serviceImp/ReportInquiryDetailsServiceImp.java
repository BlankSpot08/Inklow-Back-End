package com.example.inklow.serviceImp;

import com.example.inklow.dao.ReportInquiryDetailsDao;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.ReportInquiryDetails;
import com.example.inklow.service.ReportInquiryDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportInquiryDetailsServiceImp implements ReportInquiryDetailsService {
    private final ReportInquiryDetailsDao reportInquiryDetailsDao;

    public ReportInquiryDetailsServiceImp(ReportInquiryDetailsDao reportInquiryDetailsDao) {
        this.reportInquiryDetailsDao = reportInquiryDetailsDao;
    }

    @Override
    public List<ReportInquiryDetails> getListOfReportInquiryDetails() {
        List<ReportInquiryDetails> listOfReportInquiryDetails = reportInquiryDetailsDao.getListOfReportInquiryDetails();

        return listOfReportInquiryDetails;
    }

    @Override
    public List<ReportInquiryDetails> getReportInquiryDetailsById(ReportInquiry reportInquiry) {
        List<ReportInquiryDetails> temp = reportInquiryDetailsDao.getReportInquiryDetailsById(reportInquiry);

        return temp;
    }

    @Override
    public ReportInquiryDetails handleReportInquiryDetailsRegistration(ReportInquiryDetails reportInquiryDetails) {
        ReportInquiryDetails temp = reportInquiryDetailsDao.addReportInquiryDetails(reportInquiryDetails);

        return temp;
    }

    @Override
    public ReportInquiryDetails handleReportInquiryDetailsCancellation(ReportInquiryDetails reportInquiryDetails) {
        ReportInquiryDetails temp = reportInquiryDetailsDao.cancelReportInquiryDetails(reportInquiryDetails);

        return temp;
    }

    @Override
    public ReportInquiryDetails handleReportInquiryDetailsDeletion(ReportInquiryDetails reportInquiryDetails) {
        ReportInquiryDetails temp = reportInquiryDetailsDao.removeReportInquiryDetails(reportInquiryDetails);

        return temp;
    }

    @Override
    public int reportInquiryDetailsCount() {
        List<ReportInquiryDetails> listOfReportInquiryDetails = reportInquiryDetailsDao.getListOfReportInquiryDetails();

        return listOfReportInquiryDetails.size();
    }
}
