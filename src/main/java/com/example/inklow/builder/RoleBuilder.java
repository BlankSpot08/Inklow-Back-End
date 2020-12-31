package com.example.inklow.builder;

import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;

import java.util.List;
import java.util.UUID;

public class RoleBuilder {
    private UUID id;
    private String name;
    private String description;
    private List<Permission> permissions;

    public RoleBuilder() { }

    public RoleBuilder(UUID id) {
        this.id = id;
    }

    public RoleBuilder(UUID id, String name, String description, List<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }

    public RoleBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public RoleBuilder name(String name) {
        this.name = name;
        return this;
    }

    public RoleBuilder description(String description) {
        this.description = description;
        return this;
    }

    public RoleBuilder permissions(List<Permission> permissions) {
        this.permissions = permissions;
        return this;
    }

    public Role build() {
        return new Role(id, name ,description, permissions);
    }
}
