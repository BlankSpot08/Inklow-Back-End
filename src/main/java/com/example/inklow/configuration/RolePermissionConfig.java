package com.example.inklow.configuration;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.daoImp.RolePermissionsDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RolePermissionConfig {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public RolePermissionsDao rolePermissionsDao() {
        return new RolePermissionsDaoImp(jdbcTemplate);
    }
}
