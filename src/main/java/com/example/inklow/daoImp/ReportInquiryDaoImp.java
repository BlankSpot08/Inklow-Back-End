package com.example.inklow.daoImp;

import com.example.inklow.dao.ReportInquiryDao;
import com.example.inklow.entities.ReportInquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ReportInquiryDaoImp implements ReportInquiryDao {
    private final JdbcTemplate jdbcTemplate;

    public ReportInquiryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ReportInquiry> getListOfReportInquiry() {
        return null;
    }

    @Override
    public ReportInquiry getReportInquiryById(ReportInquiry reportInquiry) {
        return null;
    }

    @Override
    public ReportInquiry getReportInquiryByName(ReportInquiry reportInquiry) {
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
