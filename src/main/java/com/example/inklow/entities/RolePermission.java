package com.example.inklow.entities;

import java.util.UUID;

public class RolePermission {
    private final UUID roleId;
    private final UUID permissionId;

    public RolePermission(UUID roleId, UUID permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public UUID getPermissionId() {
        return permissionId;
    }

    public static final class Builder {
        private UUID roleId;
        private UUID permissionId;

        public Builder() {}

        public Builder(UUID roleId, UUID permissionId) {
            this.roleId = roleId;
            this.permissionId = permissionId;
        }

        public Builder roleId(UUID roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder permissionId(UUID permissionId) {
            this.permissionId = permissionId;
            return this;
        }

        public RolePermission build() {
            return new RolePermission(roleId, permissionId);
        }
    }

}
