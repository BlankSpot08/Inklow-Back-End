package com.example.inklow.controller;

import com.example.inklow.entities.ReportInquiryDetails;
import com.example.inklow.entities.ReportInquiryReply;
import com.example.inklow.service.ReportInquiryReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api" + ReportInquiryReplyController.REPORT_INQUIRY_REPLY_ENDPOINTS.REPORT_INQUIRY_REPLY)
public class ReportInquiryReplyController {
    private final ReportInquiryReplyService reportInquiryReplyService;

    @Autowired
    public ReportInquiryReplyController(ReportInquiryReplyService reportInquiryReplyService) {
        this.reportInquiryReplyService = reportInquiryReplyService;
    }

    @RequestMapping(value = REPORT_INQUIRY_REPLY_ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllReportInquiry() {
        List<ReportInquiryReply> temp = reportInquiryReplyService.getListOfReportInquiryReply();

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    @RequestMapping(value = REPORT_INQUIRY_REPLY_ENDPOINTS.ADD, method = RequestMethod.POST)
    public ResponseEntity<?> addReportInquiry(@RequestBody ReportInquiryReply reportInquiryReply) {
        ReportInquiryReply temp = reportInquiryReplyService.handleReportInquiryReplyRegistration(reportInquiryReply);

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    protected static final class REPORT_INQUIRY_REPLY_ENDPOINTS {
        protected static final String REPORT_INQUIRY_REPLY = "/report_inquiry_reply";

        protected static final String GET = "/get";

        protected static final String GET_ALL = "/getAll";

        protected static final String ADD = "/add";
        protected static final String DELETE = "/delete";
    }
}
