package com.example.inklow.mapper;

import com.example.inklow.entities.ReportInquiryDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ReportInquiryDetailsMapper implements RowMapper<ReportInquiryDetails> {
    @Override
    public ReportInquiryDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ReportInquiryDetails.Builder()
                .id(UUID.fromString(rs.getString("id")))
                .reportInquiryId(UUID.fromString(rs.getString("reportInquiryId")))
                .details(rs.getString("details"))
                .status(rs.getString("status"))
                .dateCreated(rs.getDate("dateCreated"))
                .build();
    }
}
