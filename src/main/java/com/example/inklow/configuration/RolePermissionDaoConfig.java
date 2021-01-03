package com.example.inklow.configuration;

import com.example.inklow.dao.RolePermissionDao;
import com.example.inklow.daoImp.RolePermissionDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RolePermissionDaoConfig {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RolePermissionDaoConfig(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    @Primary
    public RolePermissionDao rolePermissionsDao() {
        return new RolePermissionDaoImp(jdbcTemplate);
    }
}
