package com.example.inklow.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ReportInquiry {
    private final UUID id;
    private final UUID userId;
    private final String category;
    private final String title;
    private final String email;
    private final String status;
    private final Date dateCreated;

    private final List<ReportInquiryDetails> listOfDetails;

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public List<ReportInquiryDetails> getListOfDetails() {
        return listOfDetails;
    }

    public ReportInquiry(UUID id,
                         UUID userId,
                         String category,
                         String title,
                         String email,
                         String status,
                         Date dateCreated,
                         List<ReportInquiryDetails> listOfReportInquiryDetails) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.title = title;
        this.email = email;
        this.status = status;
        this.dateCreated = dateCreated;
        this.listOfDetails = listOfReportInquiryDetails;
    }

    public static final class Builder {
        private UUID id;
        private UUID userId;
        private String category = "";
        private String title = "";
        private String email = "";
        private String status = "";
        private Date dateCreated = new Date();
        private List<ReportInquiryDetails> listOfDetails = new ArrayList<>();
        private ReportInquiryDetails reportInquiryDetails = new ReportInquiryDetails.Builder().build();

        public Builder() {   }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder dateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Builder listOfDetails(List<ReportInquiryDetails> listOfDetails) {
            this.listOfDetails = listOfDetails;
            return this;
        }

        public ReportInquiry build() {
            return new ReportInquiry(
                    id,
                    userId,
                    category,
                    title,
                    email,
                    status,
                    dateCreated,
                    listOfDetails);
        }
    }
}
