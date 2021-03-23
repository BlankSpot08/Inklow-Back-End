package com.example.inklow.entities;

import java.util.Date;
import java.util.UUID;

public class ReportInquiryDetails {
    private final UUID id;
    private final UUID reportInquiryId;
    private final String details;
    private final Date dateCreated;

    private ReportInquiryReply reply;

    public UUID getId() {
        return id;
    }

    public UUID getReportInquiryId() {
        return reportInquiryId;
    }

    public String getDetails() {
        return details;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public ReportInquiryReply getReply() {
        return reply;
    }

    public void setReply(ReportInquiryReply reply) {
        this.reply = reply;
    }

    public ReportInquiryDetails(
            UUID id,
            UUID reportInquiryId,
            String details,
            Date dateCreated,
            ReportInquiryReply reply) {
        this.id = id;
        this.reportInquiryId = reportInquiryId;
        this.details = details;
        this.dateCreated = dateCreated;
        this.reply = reply;
    }

    public static final class Builder {
        private UUID id;
        private UUID reportInquiryId;
        private String details = "";
        private Date dateCreated = new Date();

        private ReportInquiryReply reply;

        public Builder() {  }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder reportInquiryId(UUID reportInquiryId) {
            this.reportInquiryId = reportInquiryId;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public Builder dateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Builder reply(ReportInquiryReply reply) {
            this.reply = reply;
            return this;
        }

        public ReportInquiryDetails build() {
            return new ReportInquiryDetails(
                    id,
                    reportInquiryId,
                    details,
                    dateCreated,
                    reply);
        }
    }
}
