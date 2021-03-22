package com.example.inklow.service;

import com.example.inklow.entities.ReportInquiryDetails;
import com.example.inklow.entities.ReportInquiryReply;

import java.util.List;

public interface ReportInquiryReplyService {
    List<ReportInquiryReply> getListOfReportInquiryReply();

    ReportInquiryReply getReportInquiryDetailsReplyById(ReportInquiryDetails reportInquiryDetails);


}
