package com.example.inklow.daoImp;

import com.example.inklow.dao.ReportInquiryDao;
import com.example.inklow.dao.UserReportInquiryDao;
import com.example.inklow.entities.ReportInquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class UserReportInquiryDaoImp implements UserReportInquiryDao {
    private final JdbcTemplate jdbcTemplate;
    private final ReportInquiryDao reportInquiryDao;

    @Autowired
    public UserReportInquiryDaoImp(JdbcTemplate jdbcTemplate,
                                   ReportInquiryDao reportInquiryDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.reportInquiryDao = reportInquiryDao;
    }

    @Override
    public List<ReportInquiry> getListOfUserReportInquiries() {
        return null;
    }

    @Override
    public List<ReportInquiry> getUserReportInquiriesById(ReportInquiry reportInquiry) {
        return null;
    }

    @Override
    public ReportInquiry addReportInquiry(ReportInquiry reportInquiry) {
        return null;
    }

    @Override
    public ReportInquiry removeReportInquiry(ReportInquiry reportInquiry) {
        return null;
    }

    @Override
    public Boolean removeAllReportInquiry() {
        return null;
    }
}
