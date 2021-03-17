package com.example.inklow.controller;

import com.example.inklow.entities.Inquiry;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.service.ReportInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping(value = "/api" + ReportInquiryController.REPORT_INQUIRY_ENDPOINTS.REPORT_INQUIRY)
public class ReportInquiryController {
    private final ReportInquiryService reportInquiryService;

    @Autowired
    public ReportInquiryController(ReportInquiryService reportInquiryService) {
        this.reportInquiryService = reportInquiryService;
    }

    @RequestMapping(value = REPORT_INQUIRY_ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllReportInquiry() {
        List<ReportInquiry> temp = reportInquiryService.getListOfReportInquiry();

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    @RequestMapping(value = REPORT_INQUIRY_ENDPOINTS.GET, method = RequestMethod.GET)
    public ResponseEntity<?> getReportInquiry(@RequestParam String title) {
        ReportInquiry reportInquiry = new ReportInquiry.Builder()
                .title(title)
                .build();

        ReportInquiry temp = reportInquiryService.getReportInquiryByTitle(reportInquiry);

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    @RequestMapping(value = REPORT_INQUIRY_ENDPOINTS.ADD, method = RequestMethod.POST)
    public ResponseEntity<?> addReportInquiry(@RequestBody ReportInquiry reportInquiry) {
        ReportInquiry temp = reportInquiryService.handleReportInquiryRegistration(reportInquiry);

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    @RequestMapping(value = REPORT_INQUIRY_ENDPOINTS.DELETE, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteReportInquiry(@RequestParam String title) {
        ReportInquiry reportInquiry = new ReportInquiry.Builder()
                .title(title)
                .build();

        ReportInquiry temp = reportInquiryService.handleReportInquiryDeletion(reportInquiry);

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    @RequestMapping(value = REPORT_INQUIRY_ENDPOINTS.DELETE_ALL, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAllReportInquiry() {
        Boolean temp = reportInquiryService.handleAllReportInquiryDeletion();

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    protected static final class REPORT_INQUIRY_ENDPOINTS {
        protected static final String REPORT_INQUIRY = "/report_inquiry";

        protected static final String GET = "/get";
        protected static final String GET_ALL = "/getAll";

        protected static final String ADD = "/add";

        protected static final String DELETE = "/delete";
        protected static final String DELETE_ALL = "/deleteAll";
    }
}
