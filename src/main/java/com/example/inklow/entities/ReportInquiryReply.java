package com.example.inklow.entities;

import java.util.Date;
import java.util.UUID;

public class ReportInquiryReply {
    private final UUID reportInquiryDetailsId;
    private final UUID userId;
    private final String details;
    private final Date dateCreated;

    public UUID getReportInquiryDetailsId() {
        return reportInquiryDetailsId;
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

    public ReportInquiryReply(UUID reportInquiryDetailsId, UUID userId, String details, Date dateCreated) {
        this.reportInquiryDetailsId = reportInquiryDetailsId;
        this.userId = userId;
        this.details = details;
        this.dateCreated = dateCreated;
    }

    public static final class Builder {
        private UUID reportInquiryDetailsId;
        private UUID userId;
        private String details = "";
        private Date dateCreated;

        public Builder() {  }

        public Builder reportInquiryDetailsId(UUID reportInquiryDetailsId) {
            this.reportInquiryDetailsId =  reportInquiryDetailsId;
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
            return new ReportInquiryReply(reportInquiryDetailsId, userId, details, dateCreated);
        }
    }
}
