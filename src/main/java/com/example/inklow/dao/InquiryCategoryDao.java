package com.example.inklow.dao;

import com.example.inklow.entities.InquiryCategory;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.RolePermission;

import java.util.List;
import java.util.UUID;

public interface InquiryCategoryDao {
    List<InquiryCategory> getListOfInquiryCategory();
    List<InquiryCategory> getInquiryCategoriesById(InquiryCategory inquiryCategory);

    InquiryCategory getInquiryCategoryById(InquiryCategory inquiryCategory);

    InquiryCategory addInquiryCategory(InquiryCategory inquiryCategory);
    InquiryCategory removeInquiryCategory(InquiryCategory inquiryCategory);

    Boolean removeAllInquiryCategory();
}
