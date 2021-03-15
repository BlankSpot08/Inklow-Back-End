package com.example.inklow.daoImp;

import com.example.inklow.dao.UserReportInquiryDao;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;
import com.example.inklow.entities.UserReportInquiry;
import com.example.inklow.mapper.ReportInquiryMapper;
import com.example.inklow.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserReportInquiryDaoImp implements UserReportInquiryDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserReportInquiryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ReportInquiry> getListOfUserReportInquiries() {
        String query = "SELECT * FROM user_inquiries";

        List<ReportInquiry> reportInquiries = jdbcTemplate.query(query, new ReportInquiryMapper());

        return reportInquiries;
    }

    @Override
    public List<ReportInquiry> getUserReportInquiriesById(User user) {
        String query = "" +
                "SELECT * FROM user_inquiries AS ui" +
                "JOIN report_inquiry AS ri ON ri.id = ui.reportInquiryId" +
                "WHERE ui.id = ri.userId";

        List<ReportInquiry> reportInquiries = jdbcTemplate.query(query, new Object[] { user.getId() }, new ReportInquiryMapper());

        return reportInquiries;
    }

    @Override
    public UserReportInquiry addUserReportInquiry(UserReportInquiry userReportInquiry) {
        String query = "" +
                "INSERT INTO user_inquiries(userId, reportInquiryId)" +
                "VALUES(?, ?)";

        int statusCode = jdbcTemplate.update(query, userReportInquiry.getUserId(), userReportInquiry.getReportQuiry());

        if (statusCode == 0) {
            return null;
        }

        return userReportInquiry;
    }

    @Override
    public UserReportInquiry removeUserReportInquiry(UserReportInquiry userReportInquiry) {
        String query = "" +
                "DELETE FROM user_inquiries " +
                "WHERE userId = ? AND reportInquiryId = ?";

        int statusCode = jdbcTemplate.update(query, userReportInquiry.getUserId(), userReportInquiry.getReportQuiry());

        if (statusCode == 0) {
            return null;
        }

        return userReportInquiry;
    }

    @Override
    public Boolean removeUserAllReportInquiry() {
        String query = "" +
                "DELETE FROM user_inquiries";

        int statusCode = jdbcTemplate.update(query);

        if (statusCode == 0) {
            return null;
        }

        return true;
    }
}
