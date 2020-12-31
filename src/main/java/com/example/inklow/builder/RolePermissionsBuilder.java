package com.example.inklow.builder;

import com.example.inklow.entities.RolePermissions;

import java.util.UUID;

public class RolePermissionsBuilder {
    private UUID roleId;
    private UUID permissionId;

    public RolePermissionsBuilder() {}

    public RolePermissionsBuilder(UUID roleId, UUID permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public RolePermissionsBuilder roleId(UUID roleId) {
        this.roleId = roleId;
        return this;
    }

    public RolePermissionsBuilder permissionId(UUID permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    public RolePermissions build() {
        return new RolePermissions(roleId, permissionId);
    }
}
