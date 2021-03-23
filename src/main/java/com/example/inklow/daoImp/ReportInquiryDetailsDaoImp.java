package com.example.inklow.daoImp;

import com.example.inklow.dao.ReportInquiryDetailsDao;
import com.example.inklow.dao.ReportInquiryReplyDao;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.ReportInquiryDetails;
import com.example.inklow.entities.ReportInquiryReply;
import com.example.inklow.mapper.ReportInquiryDetailsMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportInquiryDetailsDaoImp implements ReportInquiryDetailsDao {
    private final JdbcTemplate jdbcTemplate;
    private final ReportInquiryReplyDao reportInquiryReplyDao;

    public ReportInquiryDetailsDaoImp(JdbcTemplate jdbcTemplate,
                                      ReportInquiryReplyDao reportInquiryReplyDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.reportInquiryReplyDao = reportInquiryReplyDao;
    }

    @Override
    public List<ReportInquiryDetails> getListOfReportInquiryDetails() {
        String query = "SELECT * FROM report_inquiry_details";

        List<ReportInquiryDetails> listOfReportInquiryDetails = jdbcTemplate.query(query, new ReportInquiryDetailsMapper());

        for (ReportInquiryDetails reportInquiryDetail : listOfReportInquiryDetails) {
            ReportInquiryReply reportInquiryReply = reportInquiryReplyDao.getReportInquiryDetailsReplyById(reportInquiryDetail);

            reportInquiryDetail.setReply(reportInquiryReply);
        }

        return listOfReportInquiryDetails;
    }

    @Override
    public List<ReportInquiryDetails> getReportInquiryDetailsById(ReportInquiry reportInquiry) {
        String query = "" +
                "SELECT rid.id, rid.reportInquiryId, rid.details, rid.dateCreated FROM report_inquiry AS ri " +
                "JOIN report_inquiry_details AS rid ON rid.reportInquiryId = ri.id " +
                "WHERE ri.id = ?";

        List<ReportInquiryDetails> listOfReportInquiryDetails = jdbcTemplate.query(
                query, new Object[] { reportInquiry.getId() }, new ReportInquiryDetailsMapper());

        for (ReportInquiryDetails reportInquiryDetail : listOfReportInquiryDetails) {
            ReportInquiryReply reportInquiryReply = reportInquiryReplyDao.getReportInquiryDetailsReplyById(reportInquiryDetail);

            reportInquiryDetail.setReply(reportInquiryReply);
        }
        return listOfReportInquiryDetails;
    }

    @Override
    public ReportInquiryDetails addReportInquiryDetails(ReportInquiryDetails reportInquiryDetails) {
        String query = "" +
                "INSERT INTO report_inquiry_details(reportInquiryId, details, dateCreated) " +
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
