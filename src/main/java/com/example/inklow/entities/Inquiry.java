package com.example.inklow.entities;

import java.util.List;
import java.util.UUID;

public class Inquiry {
    private final UUID id;
    private final String name;

    private List<CategoryInquiry> categories;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<CategoryInquiry> getCategories() {
        return categories;
    }

    public Inquiry(UUID id, String name, List<CategoryInquiry> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public final static class Builder {
        private UUID id;
        private String name = "";

        private List<CategoryInquiry> categories;

        public Builder() {}

        public Builder(UUID id, String name, List<CategoryInquiry> categories) {
            this.id = id;
            this.name = name;
            this.categories = categories;
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder categories(List<CategoryInquiry> categories) {
            this.categories = categories;
            return this;
        }

        public Inquiry build() {
            return new Inquiry(id, name, categories);
        }
    }
}
