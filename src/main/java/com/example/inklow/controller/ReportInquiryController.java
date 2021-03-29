package com.example.inklow.controller;

import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.ReportInquiryDetails;
import com.example.inklow.entities.User;
import com.example.inklow.security.util.JwtUtil;
import com.example.inklow.service.ReportInquiryDetailsService;
import com.example.inklow.service.ReportInquiryService;
import com.example.inklow.service.UserService;
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
    private final ReportInquiryDetailsService reportInquiryDetailService;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public ReportInquiryController(ReportInquiryService reportInquiryService,
                                   JwtUtil jwtUtil,
                                   UserService userService,
                                   ReportInquiryDetailsService reportInquiryDetailsService) {
        this.reportInquiryDetailService = reportInquiryDetailsService;
        this.reportInquiryService = reportInquiryService;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping(value = REPORT_INQUIRY_ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllReportInquiry() {
        List<ReportInquiry> temp = reportInquiryService.getListOfReportInquiry();

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    @RequestMapping(value = REPORT_INQUIRY_ENDPOINTS.GET_WITH_USER, method = RequestMethod.POST)
    public ResponseEntity<?> getUserReportInquiries(@RequestHeader(name = "Authorization") String authorizationHeader) {
        String jwt = authorizationHeader.split(" ")[1];

        String username = jwtUtil.extractUsername(jwt);

        User user = userService.findUserByUsername(username);

        List<ReportInquiry> listOfReportInquiry = reportInquiryService.getUserListOfReportInquiry(user);

        return ResponseEntity.status(HttpStatus.OK).body(listOfReportInquiry);
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

    @RequestMapping(value = REPORT_INQUIRY_ENDPOINTS.CANCEL, method = RequestMethod.PATCH)
    public ResponseEntity<?> cancelReportInquiry(@RequestParam String title) {
        ReportInquiry reportInquiry = new ReportInquiry.Builder()
                .title(title)
                .build();

        ReportInquiry temp = reportInquiryService.handleReportInquiryCancellation(reportInquiry);

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

        protected static final String GET_WITH_USER = "/get_with_user";
        protected static final String CANCEL = "/cancel";

        protected static final String GET_ALL = "/getAll";

        protected static final String ADD = "/add";

        protected static final String DELETE = "/delete";
        protected static final String DELETE_ALL = "/deleteAll";
    }
}