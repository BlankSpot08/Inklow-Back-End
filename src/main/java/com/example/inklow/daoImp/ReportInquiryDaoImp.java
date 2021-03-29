package com.example.inklow.daoImp;

import com.example.inklow.dao.ReportInquiryDao;
import com.example.inklow.dao.ReportInquiryDetailsDao;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.ReportInquiryDetails;
import com.example.inklow.entities.User;
import com.example.inklow.mapper.ReportInquiryMapper;
import com.example.inklow.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class ReportInquiryDaoImp implements ReportInquiryDao {
    private final JdbcTemplate jdbcTemplate;
    private final ReportInquiryDetailsDao reportInquiryDetailsDao;

    @Autowired
    public ReportInquiryDaoImp(final JdbcTemplate jdbcTemplate,
                               ReportInquiryDetailsDao reportInquiryDetailsDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.reportInquiryDetailsDao = reportInquiryDetailsDao;
    }

    @Override
    public List<ReportInquiry> getListOfReportInquiry() {
        String query = "SELECT * FROM report_inquiry";

        List<ReportInquiry> listOfReportInquiry = jdbcTemplate.query(query, new ReportInquiryMapper());

        for (ReportInquiry reportInquiry : listOfReportInquiry) {
            List<ReportInquiryDetails> listOfReportInquiryDetails = reportInquiryDetailsDao.getReportInquiryDetailsById(reportInquiry);

            reportInquiry.setListOfDetails(listOfReportInquiryDetails);
        }

        return listOfReportInquiry;
    }

    @Override
    public List<ReportInquiry> getUserListOfReportInquiry(User user) {
        String query = "" +
                "SELECT ri.id, ri.userId, ri.category, ri.email, ri.title, ri.status, ri.dateCreated, ri.lastUpdated FROM users AS u " +
                "JOIN report_inquiry AS ri ON ri.userId = u.id " +
                "WHERE u.id = ?";

        List<ReportInquiry> listOfReportInquiry = jdbcTemplate.query(query,
                new Object[] { user.getId() }, new ReportInquiryMapper());

        for (ReportInquiry reportInquiry : listOfReportInquiry) {
            List<ReportInquiryDetails> listOfReportInquiryDetails = reportInquiryDetailsDao.getReportInquiryDetailsById(reportInquiry);

            reportInquiry.setListOfDetails(listOfReportInquiryDetails);
        }

        return listOfReportInquiry;
    }

    @Override
    public ReportInquiry getReportInquiryById(ReportInquiry reportInquiry) {
        String query = "" +
                "SELECT * FROM report_inquiry" +
                " WHERE id = ?";

        ReportInquiry temp = jdbcTemplate.queryForObject(query, new Object[] { reportInquiry.getId() }, new ReportInquiryMapper());

        List<ReportInquiryDetails> listOfReportInquiryDetails = reportInquiryDetailsDao.getReportInquiryDetailsById(temp);
        temp.setListOfDetails(listOfReportInquiryDetails);

        return temp;
    }

    @Override
    public ReportInquiry getReportInquiryByTitle(ReportInquiry reportInquiry) {
        String query = "" +
                "SELECT * FROM report_inquiry " +
                "WHERE title = ?";

        ReportInquiry temp = jdbcTemplate.queryForObject(query, new Object[] { reportInquiry.getTitle() }, new ReportInquiryMapper());

        List<ReportInquiryDetails> listOfReportInquiryDetails = reportInquiryDetailsDao.getReportInquiryDetailsById(temp);
        temp.setListOfDetails(listOfReportInquiryDetails);

        return temp;
    }

    @Override
    public ReportInquiry addReportInquiry(ReportInquiry reportInquiry) {
        String query = "" +
                "INSERT INTO report_inquiry(userId, category, email, title, status, dateCreated, lastUpdated) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        int statusCode = jdbcTemplate.update(query,
                reportInquiry.getUserId(), reportInquiry.getCategory(), reportInquiry.getEmail(),
                reportInquiry.getTitle(), reportInquiry.getStatus(), reportInquiry.getDateCreated(),
                reportInquiry.getLastUpdated());

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
