package com.example.inklow.daoImp;

import com.example.inklow.dao.ReportInquiryReplyDao;
import com.example.inklow.entities.ReportInquiryDetails;
import com.example.inklow.entities.ReportInquiryReply;
import com.example.inklow.mapper.ReportInquiryReplyMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportInquiryReplyDaoImp implements ReportInquiryReplyDao {
    private final JdbcTemplate jdbcTemplate;

    public ReportInquiryReplyDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ReportInquiryReply> getListOfReportInquiryReply() {
        String query = "" +
                "SELECT * FROM report_inquiry_reply";

        List<ReportInquiryReply> listOfReportInquiryReply = jdbcTemplate.query(query, new ReportInquiryReplyMapper());

        return listOfReportInquiryReply;
    }

    @Override
    public ReportInquiryReply getReportInquiryDetailsReplyById(ReportInquiryDetails reportInquiryDetails) {
        String query = "" +
                "SELECT * FROM report_inquiry_details AS rid" +
                "JOIN report_inquiry_reply AS rir ON rir.reportInquiryDetailsId = rid.id" +
                "WHERE rid.id = ?";

        ReportInquiryReply reportInquiryReply = jdbcTemplate.queryForObject(query, new Object[] { reportInquiryDetails.getId() }, new ReportInquiryReplyMapper());

        return reportInquiryReply;
    }

    @Override
    public ReportInquiryReply addReportInquiryDetailsReply(ReportInquiryReply replyInquiryReply) {
        String query = "" +
                "INSERT INTO report_inquiry_reply(reportInquiryDetailsId, userId, details, dateCreated)" +
                "VALUES(?, ?, ?, ?)";

        int statusCode = jdbcTemplate.update(query,
                replyInquiryReply.getReportInquiryDetailsId(),
                replyInquiryReply.getUserId(),
                replyInquiryReply.getDetails(),
                replyInquiryReply.getDateCreated());

        if (statusCode == 0) {
            return null;
        }

        return replyInquiryReply;
    }

    @Override
    public ReportInquiryReply deleteReportInquiryDetailsReply(ReportInquiryReply reportInquiryReply) {
        String query = "" +
                "DELETE FROM reply_inquiry_reply AS rir" +
                "WHERE rir.reportInquiryDetailsId = ? AND userId = ?";

        int statusCode = jdbcTemplate.update(query,
                reportInquiryReply.getReportInquiryDetailsId(),
                reportInquiryReply.getUserId());

        if (statusCode == 0) {
            return reportInquiryReply;
        }

        return null;
    }
}
