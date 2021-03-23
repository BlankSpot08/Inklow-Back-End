package com.example.inklow.serviceImp;

import com.example.inklow.dao.ReportInquiryDao;
import com.example.inklow.dao.ReportInquiryReplyDao;
import com.example.inklow.entities.ReportInquiryDetails;
import com.example.inklow.entities.ReportInquiryReply;
import com.example.inklow.service.ReportInquiryReplyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportInquiryReplyServiceImp implements ReportInquiryReplyService {
    private final ReportInquiryReplyDao reportInquiryReplyDao;

    public ReportInquiryReplyServiceImp(ReportInquiryReplyDao reportInquiryReplyDao) {
        this.reportInquiryReplyDao = reportInquiryReplyDao;
    }

    @Override
    public List<ReportInquiryReply> getListOfReportInquiryReply() {
        List<ReportInquiryReply> listOfReportInquiryReply = reportInquiryReplyDao.getListOfReportInquiryReply();

        return listOfReportInquiryReply;
    }

    @Override
    public ReportInquiryReply getReportInquiryDetailsReplyById(ReportInquiryDetails reportInquiryDetails) {
        ReportInquiryReply reportInquiryReply = reportInquiryReplyDao.getReportInquiryDetailsReplyById(reportInquiryDetails);

        return reportInquiryReply;
    }

    @Override
    public ReportInquiryReply handleReportInquiryReplyRegistration(ReportInquiryReply reportInquiryReply) {
        ReportInquiryReply temp = reportInquiryReplyDao.addReportInquiryDetailsReply(reportInquiryReply);

        return temp;
    }

    @Override
    public ReportInquiryReply handleReportInquiryReplyDeletion(ReportInquiryReply reportInquiryReply) {
        ReportInquiryReply temp = reportInquiryReplyDao.deleteReportInquiryDetailsReply(reportInquiryReply);

        return temp;
    }
}
