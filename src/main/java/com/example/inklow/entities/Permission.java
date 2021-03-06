package com.example.inklow.entities;

import java.util.UUID;

public class Permission {
    private final UUID id;
    private String name;
    private String description;

    public Permission(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public final static class Builder {
        private UUID id;
        private String name;
        private String description;

        public Builder() {}

        public Builder(UUID id) {
            this.id = id;
        }

        public Builder(UUID id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Permission build() {
            return new Permission(id, name, description);
        }
    }

}
