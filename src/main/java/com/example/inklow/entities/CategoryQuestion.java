package com.example.inklow.entities;

import java.util.UUID;

public class CategoryQuestion {
    private final UUID id;
    private final String name;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CategoryQuestion(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static final class Builder {
        private UUID id;
        private String name = "";

        public Builder() {  }

        public Builder(UUID id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryQuestion build() {
            return new CategoryQuestion(id, name);
        }
    }
}
