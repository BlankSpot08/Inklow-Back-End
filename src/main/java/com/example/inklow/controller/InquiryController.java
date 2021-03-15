package com.example.inklow.controller;

import com.example.inklow.entities.Inquiry;
import com.example.inklow.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping(value = "/api" + InquiryController.INQUIRY_ENDPOINTS.INQUIRY)
public class InquiryController {
    private final InquiryService inquiryService;

    @Autowired
    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @RequestMapping(value = INQUIRY_ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllInquiry() {
        List<Inquiry> temp = inquiryService.getListOfInquiry();

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    @RequestMapping(value = INQUIRY_ENDPOINTS.GET, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryByName(@RequestParam String name) {
        Inquiry inquiry = new Inquiry.Builder()
                .name(name)
                .build();

        Inquiry temp = inquiryService.getInquiryByName(inquiry);

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    @RequestMapping(value = INQUIRY_ENDPOINTS.GET_CATEGORY, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryCategoriesByName(@RequestParam String name) {
        Inquiry inquiry = new Inquiry.Builder()
                .name(name)
                .build();

        Inquiry temp = inquiryService.getInquiryByName(inquiry);

        return ResponseEntity.status(HttpStatus.OK).body(temp.getCategories());
    }

    @RequestMapping(value = INQUIRY_ENDPOINTS.DELETE, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAllInquiry(@RequestParam String name) {
        Inquiry inquiry = new Inquiry.Builder()
                .name(name)
                .build();

        Inquiry temp = inquiryService.handleInquiryDeletion(inquiry);

        return ResponseEntity.status(HttpStatus.OK).body(temp);
    }

    protected static final class INQUIRY_ENDPOINTS {
        protected static final String INQUIRY = "/inquiry";

        protected static final String GET = "/get";

        protected static final String GET_CATEGORY = "/get_category";

        protected static final String GET_ALL = "/getAll";

        protected static final String DELETE = "/delete";
        protected static final String DELETE_ALL = "/deleteAll";
    }
}
