package com.example.inklow.controller;

import com.example.inklow.dao.CategoryInquiryDao;
import com.example.inklow.dao.InquiryCategoryDao;
import com.example.inklow.dao.InquiryDao;
import com.example.inklow.entities.CategoryInquiry;
import com.example.inklow.entities.Inquiry;
import com.example.inklow.entities.InquiryCategory;
import com.example.inklow.entities.Question;
import com.example.inklow.service.InquiryService;
import com.example.inklow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping(value = "/api")
public class SupportController {
    private final InquiryService inquiryService;
    private final InquiryDao inquiryDao;
    private final CategoryInquiryDao categoryInquiryDao;
    private final InquiryCategoryDao inquiryCategoryDao;

    @Autowired
    public SupportController(
                             InquiryService inquiryService,
                             InquiryDao inquiryDao,
                             CategoryInquiryDao categoryInquiryDao,
                             InquiryCategoryDao inquiryCategoryDao) {
        this.inquiryService = inquiryService;

        this.inquiryDao = inquiryDao;
        this.categoryInquiryDao = categoryInquiryDao;
        this.inquiryCategoryDao = inquiryCategoryDao;
    }}

