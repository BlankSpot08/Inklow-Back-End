package com.example.inklow.entities;

import java.util.UUID;

public class UserReportInquiry {
    private final UUID userId;
    private final UUID reportInquiryId;

    public UUID getUserId() {
        return userId;
    }

    public UUID getReportInquiryId() {
        return reportInquiryId;
    }

    public UserReportInquiry(UUID userId, UUID reportInquiryId) {
        this.userId = userId;
        this.reportInquiryId = reportInquiryId;
    }
}
