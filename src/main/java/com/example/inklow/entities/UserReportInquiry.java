package com.example.inklow.entities;

import java.util.UUID;

public class UserReportInquiry {
    private final UUID userId;
    private final UUID reportQuiry;

    public UUID getUserId() {
        return userId;
    }

    public UUID getReportQuiry() {
        return reportQuiry;
    }

    public UserReportInquiry(UUID userId, UUID reportQuiry) {
        this.userId = userId;
        this.reportQuiry = reportQuiry;
    }
}
