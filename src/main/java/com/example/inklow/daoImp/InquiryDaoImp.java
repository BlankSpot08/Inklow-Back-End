package com.example.inklow.daoImp;

import com.example.inklow.dao.InquiryDao;
import com.example.inklow.entities.Inquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class InquiryDaoImp implements InquiryDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InquiryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Inquiry> listOfInquiries() {
        return null;
    }

    @Override
    public Inquiry findInquiryById() {
        return null;
    }

    @Override
    public Inquiry addInquiry(Inquiry inquiry) {
        return null;
    }

    @Override
    public Inquiry deleteInquiry(Inquiry inquiry) {
        return null;
    }

    @Override
    public Inquiry updateInquiry(Inquiry inquiry) {
        return null;
    }

    @Override
    public Boolean removeAllInquiry() {
        return null;
    }
}
