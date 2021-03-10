package com.example.inklow.entities;

import java.util.UUID;

public class InquiryCategory {
    private final UUID inquiryId;
    private final UUID categoryId;

    public UUID getInquiryId() {
        return inquiryId;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public InquiryCategory(UUID inquiryId, UUID categoryId) {
        this.inquiryId = inquiryId;
        this.categoryId = categoryId;
    }

    public static final class Builder {
        private UUID inquiryId;
        private UUID categoryId;

        public Builder() {  }

        public Builder(UUID inquiryId, UUID categoryId) {
            this.inquiryId = inquiryId;
            this.categoryId = categoryId;
        }

        public Builder inquiryId(UUID inquiryId) {
            this.inquiryId = inquiryId;
            return this;
        }

        public Builder categoryId(UUID categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public InquiryCategory build() {
            return new InquiryCategory(inquiryId, categoryId);
        }
    }
}
