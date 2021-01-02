package com.example.inklow.entities;

import java.util.List;
import java.util.UUID;

public class Role {
    private final UUID id;
    private String name;
    private String description;
    private List<Permission> permissions;

    public Role(UUID id, String name, String description, List<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.permissions = permissions;
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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public static final class Builder {
        private UUID id;
        private String name;
        private String description;
        private List<Permission> permissions;

        public Builder() { }

        public Builder(UUID id) {
            this.id = id;
        }

        public Builder(UUID id, String name, String description, List<Permission> permissions) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.permissions = permissions;
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

        public Builder permissions(List<Permission> permissions) {
            this.permissions = permissions;
            return this;
        }

        public Role build() {
            return new Role(id, name ,description, permissions);
        }
    }

}

