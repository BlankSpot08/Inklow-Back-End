package com.example.inklow.controller;

import com.example.inklow.entities.User;
import com.example.inklow.entities.UserReportInquiry;
import com.example.inklow.service.UserReportInquiryService;
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
@RequestMapping(value = "/api" + UserReportInquiryController.USER_REPORT_INQUIRY_ENDPOINTS.USER_REPORT_INQUIRY)
public class UserReportInquiryController {
    private final UserReportInquiryService userReportInquiryService;

    @Autowired
    public UserReportInquiryController(UserReportInquiryService userReportInquiryService) {
        this.userReportInquiryService = userReportInquiryService;
    }

    @RequestMapping(value = USER_REPORT_INQUIRY_ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllUserReportInquiry() {
        List<UserReportInquiry> listOfUserReportInquiry = userReportInquiryService.getListOfUserReportInquiries();

        return ResponseEntity.status(HttpStatus.OK).body(listOfUserReportInquiry);
    }

    @RequestMapping(value = USER_REPORT_INQUIRY_ENDPOINTS.ADD, method = RequestMethod.POST)
    public ResponseEntity<?> addUserReportInquiry(@RequestBody UserReportInquiry userReportInquiry) {
        UserReportInquiry temp = userReportInquiryService.handleUserReportInquiryRegistration(userReportInquiry);

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    @RequestMapping(value = USER_REPORT_INQUIRY_ENDPOINTS.DELETE, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserReportInquiry(@RequestBody UserReportInquiry userReportInquiry) {
        UserReportInquiry temp = userReportInquiryService.handleUserReportInquiryDeletion(userReportInquiry);

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    protected static final class USER_REPORT_INQUIRY_ENDPOINTS {
        protected static final String USER_REPORT_INQUIRY = "/user_report_inquiry";

        protected static final String ADD = "/add";

        protected static final String GET = "/get";

        protected static final String GET_ALL = "/getAll";

        protected static final String DELETE = "/delete";
    }
}