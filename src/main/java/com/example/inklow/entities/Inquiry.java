package com.example.inklow.entities;

import java.io.File;
import java.util.UUID;

public class Inquiry {
    private final UUID id;
    private final String category;
    private final String email;
    private final String title;
    private String details;
    private final File[] files;

    public String getCategory() {
        return category;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public File[] getFiles() {
        return files;
    }

    public Inquiry(UUID id, String category, String email, String title, String details, File[] files) {
        this.id = id;
        this.category = category;
        this.email = email;
        this.title = title;
        this.details = details;
        this.files = files;
    }

    public final static class Builder {
        private UUID id;
        private String category = "";
        private String email = "";
        private String title = "";
        private String details = "";
        private File[] files = new File[4];

        public Builder(UUID id, String category, String email, String title, String details, File[] files) {
            this.id = id;
            this.category = category;
            this.email = email;
            this.title = title;
            this.details = details;
            this.files = files;
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder details(String details)  {
            this.details = details;
            return this;
        }

        public Builder files(File[] files) {
            this.files = files;
            return this;
        }

        public Inquiry build()  {
            return new Inquiry(id, category, email, title, details, files);
        }
    }
}
