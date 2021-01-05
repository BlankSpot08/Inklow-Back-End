package com.example.inklow.configuration;

import com.example.inklow.dao.RolePermissionDao;
import com.example.inklow.service.RolePermissionService;
import com.example.inklow.serviceImp.RolePermissionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RolePermissionServiceConfig {
    private final RolePermissionDao rolePermissionDao;

    @Autowired
    public RolePermissionServiceConfig(RolePermissionDao rolePermissionDao) {
        this.rolePermissionDao = rolePermissionDao;
    }

    @Bean
    @Primary
    public RolePermissionService rolePermissionService() {
        return new RolePermissionServiceImp(rolePermissionDao);
    }
}
