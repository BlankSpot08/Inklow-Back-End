package com.example.inklow.entities;

import java.util.UUID;

public class UserRole {
    private final UUID userId;
    private final UUID roleId;

    public UserRole(UUID userId, UUID roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getRoleId() {
        return roleId;
    }
}
