package com.example.inklow.configuration;

import com.example.inklow.dao.PermissionDao;
import com.example.inklow.daoImp.PermissionDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class PermissionConfig {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public PermissionDao permissionDao() {
        return new PermissionDaoImp(jdbcTemplate);
    }
}
