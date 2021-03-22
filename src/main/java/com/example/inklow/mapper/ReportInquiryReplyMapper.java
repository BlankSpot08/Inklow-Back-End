package com.example.inklow.mapper;

import com.example.inklow.entities.ReportInquiryReply;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public final class ReportInquiryReplyMapper implements RowMapper<ReportInquiryReply> {
    @Override
    public ReportInquiryReply mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ReportInquiryReply.Builder()
                .userId(UUID.fromString(rs.getString("userId")))
                .reportInquiryDetailsId(UUID.fromString(rs.getString("reportInquiryDetailsId")))
                .details(rs.getString("details"))
                .dateCreated(rs.getDate("dateCreated"))
                .build();
    }
}
