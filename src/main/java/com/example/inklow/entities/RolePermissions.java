package com.example.inklow.entities;

import java.util.UUID;

public class RolePermissions {
    private final UUID roleId;
    private final UUID permissionId;

    public RolePermissions(UUID roleId, UUID permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public UUID getPermissionId() {
        return permissionId;
    }
}
