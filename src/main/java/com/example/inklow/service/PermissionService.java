package com.example.inklow.service;

import com.example.inklow.entities.Permission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PermissionService {
    List<Permission> getListOfPermission();

    Permission getPermissionById(UUID id);
    Permission getPermissionByName(String name);

    Permission handlePermissionRegistration(Permission permission);
    Permission handlePermissionDeletion(Permission permission);

    int permissionCount();
}
