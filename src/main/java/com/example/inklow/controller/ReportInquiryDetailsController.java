package com.example.inklow.controller;

import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.ReportInquiryDetails;
import com.example.inklow.service.ReportInquiryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping(value = "/api" + ReportInquiryDetailsController.REPORT_INQUIRY_DETAILS_ENDPOINTS.REPORT_INQUIRY_DETAILS)
public class ReportInquiryDetailsController {
    private final ReportInquiryDetailsService reportInquiryDetailsService;

    @Autowired
    public ReportInquiryDetailsController(ReportInquiryDetailsService reportInquiryDetailsService) {
        this.reportInquiryDetailsService = reportInquiryDetailsService;
    }

    @RequestMapping(value = REPORT_INQUIRY_DETAILS_ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllReportInquiryDetails() {
        List<ReportInquiryDetails> temp = reportInquiryDetailsService.getListOfReportInquiryDetails();

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    @RequestMapping(value = REPORT_INQUIRY_DETAILS_ENDPOINTS.ADD, method = RequestMethod.POST)
    public ResponseEntity<?> addReportInquiryDetails(@RequestBody ReportInquiryDetails reportInquiryDetails) {
        System.out.println(reportInquiryDetails.getId());
        System.out.println(reportInquiryDetails.getReportInquiryId());
        System.out.println(reportInquiryDetails.getDetails());
        System.out.println(reportInquiryDetails.getDateCreated());
        ReportInquiryDetails temp = reportInquiryDetailsService.handleReportInquiryDetailsRegistration(reportInquiryDetails);

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    protected static final class REPORT_INQUIRY_DETAILS_ENDPOINTS {
        protected static final String REPORT_INQUIRY_DETAILS = "/report_inquiry_details";

        protected static final String GET = "/get";

        protected static final String GET_ALL = "/getAll";

        protected static final String ADD = "/add";
        protected static final String DELETE = "/delete";
    }
}
