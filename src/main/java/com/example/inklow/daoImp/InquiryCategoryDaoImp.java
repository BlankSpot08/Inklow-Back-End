package com.example.inklow.daoImp;

import com.example.inklow.dao.InquiryCategoryDao;
import com.example.inklow.dao.InquiryDao;
import com.example.inklow.entities.Inquiry;
import com.example.inklow.entities.InquiryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class InquiryCategoryDaoImp implements InquiryCategoryDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InquiryCategoryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<InquiryCategory> getInquiryCategoryById(UUID id) {
        return null;
    }

    @Override
    public List<InquiryCategory> getListOfInquiryCategory() {
        return null;
    }

    @Override
    public InquiryCategory addInquiryCategory(InquiryCategory inquiryCategory) {
        return null;
    }

    @Override
    public InquiryCategory removeInquiryCategory(InquiryCategory inquiryCategory) {
        return null;
    }

    @Override
    public Boolean removeAllInquiryCategory() {
        return null;
    }
}
