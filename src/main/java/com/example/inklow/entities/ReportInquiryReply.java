package com.example.inklow.entities;

import java.util.Date;
import java.util.UUID;

public class ReportInquiryReply {
    private final UUID reportInquiryId;
    private final UUID userId;
    private final String details;
    private final Date dateCreated;

    public UUID getReportInquiryId() {
        return reportInquiryId;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getDetails() {
        return details;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public ReportInquiryReply(UUID reportInquiryId, UUID userId, String details, Date dateCreated) {
        this.reportInquiryId = reportInquiryId;
        this.userId = userId;
        this.details = details;
        this.dateCreated = dateCreated;
    }

    public static final class Builder {
        private UUID reportInquiryId;
        private UUID userId;
        private String details = "";
        private Date dateCreated;

        public Builder() { }

        public Builder reportInquiryId(UUID reporyInquiryId) {
            this.reportInquiryId =  reporyInquiryId;
            return this;
        }

        public Builder userId(UUID userId) {
            this.userId =  userId;
            return this;
        }

        public Builder details(String details) {
            this.details =  details;
            return this;
        }

        public Builder dateCreated(Date dateCreated) {
            this.dateCreated =  dateCreated;
            return this;
        }

        public ReportInquiryReply build()  {
            return new ReportInquiryReply(reportInquiryId, userId, details, dateCreated);
        }
    }
}
