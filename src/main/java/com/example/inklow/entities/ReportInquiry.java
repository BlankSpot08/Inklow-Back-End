package com.example.inklow.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ReportInquiry {
    private final UUID id;
    private UUID userId;
    private final String category;
    private final String title;
    private final String email;
    private String status;
    private Date dateCreated;
    private Date lastUpdated;

    private List<ReportInquiryDetails> listOfDetails;

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

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public List<ReportInquiryDetails> getListOfDetails() {
        return listOfDetails;
    }

    public void setListOfDetails(List<ReportInquiryDetails> listOfDetails) {
        this.listOfDetails = listOfDetails;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ReportInquiry(UUID id,
                         UUID userId,
                         String category,
                         String title,
                         String email,
                         String status,
                         Date dateCreated,
                         Date lastUpdated,
                         List<ReportInquiryDetails> listOfReportInquiryDetails) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.title = title;
        this.email = email;
        this.status = status;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
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
        private Date lastUpdated = new Date();
        private List<ReportInquiryDetails> listOfDetails = new ArrayList<>();

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

        public Builder lastUpdated(Date lastUpdated) {
            this.lastUpdated = lastUpdated;
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
                    lastUpdated,
                    listOfDetails);
        }
    }
}
