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

    public static final class Builder {
        private UUID userId;
        private UUID roleId;

        public Builder() {}

        public Builder(UUID userId, UUID roleId) {
            this.userId = userId;
            this.roleId = roleId;
        }

        public Builder userId(UUID id) {
            this.userId = id;
            return this;
        }

        public Builder roleId(UUID id) {
            this.roleId = id;
            return this;
        }

        public UserRole build() {
            return new UserRole(userId, roleId);
        }
    }

}
