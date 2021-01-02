package com.example.inklow.builder;

import com.example.inklow.entities.UserRole;

import java.util.UUID;

public class UserRolesBuilder {
    private UUID userId;
    private UUID roleId;

    public UserRolesBuilder() {}

    public UserRolesBuilder(UUID userId, UUID roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRolesBuilder userId(UUID id) {
        this.userId = id;
        return this;
    }

    public UserRolesBuilder roleId(UUID id) {
        this.roleId = id;
        return this;
    }

    public UserRole build() {
        return new UserRole(userId, roleId);
    }
}
