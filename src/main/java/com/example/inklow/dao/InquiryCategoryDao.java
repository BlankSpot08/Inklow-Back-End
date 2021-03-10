package com.example.inklow.dao;

import com.example.inklow.entities.InquiryCategory;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.RolePermission;

import java.util.List;
import java.util.UUID;

public interface InquiryCategoryDao {
    List<InquiryCategory> getInquiryCategoryById(UUID id);

    List<InquiryCategory> getListOfInquiryCategory();

    InquiryCategory addInquiryCategory(InquiryCategory inquiryCategory);

    InquiryCategory removeInquiryCategory(InquiryCategory inquiryCategory);
    Boolean removeAllInquiryCategory();
}
