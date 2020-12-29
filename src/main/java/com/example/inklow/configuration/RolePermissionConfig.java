package com.example.inklow.configuration;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.daoImp.RolePermissionsDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RolePermissionConfig {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RolePermissionConfig(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    @Primary
    public RolePermissionsDao rolePermissionsDao() {
        return new RolePermissionsDaoImp(jdbcTemplate);
    }
}
