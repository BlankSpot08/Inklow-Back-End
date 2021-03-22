package com.example.inklow.daoImp;

import com.example.inklow.dao.ReportInquiryDetailsDao;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.ReportInquiryDetails;
import com.example.inklow.mapper.ReportInquiryDetailsMapper;
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
    public List<ReportInquiryDetails> getReportInquiryDetailsById(ReportInquiry reportInquiry) {
        String query = "" +
                "SELECT * report_inquiry as ri" +
                "JOIN report_inquiry_details AS rid ON rid.reportInquiryId = ri.id" +
                "WHERE ri.id = ?";

        List<ReportInquiryDetails> listOfReportInquiryDetails = jdbcTemplate.query(query, new Object[] { reportInquiry.getId() }, new ReportInquiryDetailsMapper());

        return listOfReportInquiryDetails;
    }

    @Override
    public ReportInquiryDetails addReportInquiryDetails(ReportInquiryDetails reportInquiryDetails) {
        String query = "" +
                "INSERT INTO report_inquiry_details(reportInquiryId, details, dateCreated)" +
                "VALUES (?, ?, ?)";

        int temp = jdbcTemplate.update(query,
                reportInquiryDetails.getReportInquiryId(),
                reportInquiryDetails.getDetails(),
                reportInquiryDetails.getDateCreated());

        if (temp == 0) {
            return null;
        }

        return reportInquiryDetails;
    }

    @Override
    public ReportInquiryDetails removeReportInquiryDetails(ReportInquiryDetails reportInquiryDetails) {
        String query = "" +
                "DELETE FROM report_inquiry_details AS rid" +
                "WHERE rid.id = ?";

        int statusCode = jdbcTemplate.update(query, reportInquiryDetails.getId());

        if (statusCode == 0) {
            return null;
        }

        return reportInquiryDetails;
    }

    @Override
    public Boolean removeAllReportInquiryDetails() {
        String query = "" +
                "DELETE FROM report_inquiry_details";

        int statusCode = jdbcTemplate.update(query);

        if (statusCode == 0) {
            return null;
        }

        return true;
    }
}
