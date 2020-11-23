package com.example.inklow.builder;

import com.example.inklow.entities.Permission;

import java.util.UUID;

public class PermissionBuilder {
    private UUID id;
    private String name;
    private String description;

    public PermissionBuilder(UUID id) {
        this.id = id;
    }

    public PermissionBuilder(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public PermissionBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public PermissionBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PermissionBuilder description(String description) {
        this.description = description;
        return this;
    }

    public Permission build() {
        return new Permission(id, name, description);
    }
}
