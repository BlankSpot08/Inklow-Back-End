package com.example.inklow.entities;

import java.util.UUID;

public class ReportInquiry {
    private final UUID id;
    private final String category;
    private final String title;
    private final String email;
    private final String details;

    public UUID getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getEmail() {
        return email;
    }

    public ReportInquiry(UUID id, String category, String title, String email, String details) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.email = email;
        this.details = details;
    }

    public static final class Builder {
        private UUID id;
        private String category = "";
        private String title = "";
        private String email = "";
        private String details = "";

        public Builder() {   }

        public Builder id(UUID id) {
            this.id = id;
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

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public ReportInquiry build() {
            return new ReportInquiry(id, category, title, email, details);
        }
    }
}
