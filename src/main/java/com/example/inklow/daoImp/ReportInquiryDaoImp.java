package com.example.inklow.daoImp;

import com.example.inklow.dao.ReportInquiryDao;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.mapper.ReportInquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportInquiryDaoImp implements ReportInquiryDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReportInquiryDaoImp(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ReportInquiry> getListOfReportInquiry() {
        String query = "SELECT * FROM report_inquiry";

        List<ReportInquiry> listOfReportInquiry = jdbcTemplate.query(query, new ReportInquiryMapper());

        return listOfReportInquiry;
    }

    @Override
    public ReportInquiry getReportInquiryById(ReportInquiry reportInquiry) {
        String query = "SELECT * FROM report_inquiry WHERE id = ?";

        ReportInquiry temp = jdbcTemplate.queryForObject(query, new Object[] { reportInquiry.getId() }, new ReportInquiryMapper());

        return temp;
    }

    @Override
    public ReportInquiry getReportInquiryByTitle(ReportInquiry reportInquiry) {
        String query = "SELECT * FROM report_inquiry WHERE title = ?";

        ReportInquiry temp = jdbcTemplate.queryForObject(query, new Object[] { reportInquiry.getTitle() }, new ReportInquiryMapper());

        return temp;
    }

    @Override
    public ReportInquiry addReportInquiry(ReportInquiry reportInquiry) {
        String query = "" +
                "INSERT INTO report_inquiry(category, email, title) " +
                "VALUES (?, ?, ?)";

        int statusCode = jdbcTemplate.update(query,
                reportInquiry.getCategory(), reportInquiry.getEmail(), reportInquiry.getTitle());

        if (statusCode == 0) {
            return null;
        }

        return reportInquiry;
    }

    @Override
    public ReportInquiry removeReportInquiry(ReportInquiry reportInquiry) {
        String query = "DELETE FROM report_inquiry WHERE id = ?";

        int statusCode = jdbcTemplate.update(query, reportInquiry.getId());

        if (statusCode == 0) {
            return null;
        }

        return reportInquiry;
    }

    @Override
    public Boolean removeAllReportInquiry() {
        String query = "DELETE FROM report_inquiry";

        int statusCode = jdbcTemplate.update(query);

        if (statusCode == 0) {
            return null;
        }

        return true;
    }
}
