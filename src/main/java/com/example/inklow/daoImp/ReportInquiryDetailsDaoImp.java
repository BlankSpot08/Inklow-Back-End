package com.example.inklow.daoImp;

import com.example.inklow.dao.ReportInquiryDetailsDao;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.ReportInquiryDetails;
import com.example.inklow.mapper.ReportInquiryDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportInquiryDetailsDaoImp implements ReportInquiryDetailsDao {
    private final JdbcTemplate jdbcTemplate;

    public ReportInquiryDetailsDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ReportInquiryDetails> getListOfReportInquiryDetails() {
        String query = "SELECT * FROM report_inquiry_details";

        List<ReportInquiryDetails> listOfReportInquiryDetails = jdbcTemplate.query(query, new ReportInquiryDetailsMapper());

        return listOfReportInquiryDetails;
    }

    @Override
    public List<ReportInquiryDetails> getReportInquiryDetailsById(ReportInquiryDetails reportInquiryDetails) {
        String query = "" +
                "SELECT * report_inquiry as ri" +
                "JOIN report_inquiry_details AS rid ON ";

        List<ReportInquiryDetails> listOfReportInquiryDetails = jdbcTemplate.query(query, new ReportInquiryDetailsMapper());

        return listOfReportInquiryDetails;
    }

    @Override
    public ReportInquiryDetails addReportInquiryDetails(ReportInquiryDetails reportInquiryDetails) {
        return null;
    }

    @Override
    public ReportInquiryDetails removeReportInquiryDetails(ReportInquiryDetails reportInquiryDetails) {
        return null;
    }

    @Override
    public Boolean removeAllReportInquiryDetails() {
        return null;
    }
}
