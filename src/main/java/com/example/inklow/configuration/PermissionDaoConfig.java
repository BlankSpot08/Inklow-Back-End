package com.example.inklow.configuration;

import com.example.inklow.dao.PermissionDao;
import com.example.inklow.daoImp.PermissionDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class PermissionDaoConfig {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PermissionDaoConfig(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    @Primary
    public PermissionDao permissionDao() {
        return new PermissionDaoImp(jdbcTemplate);
    }
}
