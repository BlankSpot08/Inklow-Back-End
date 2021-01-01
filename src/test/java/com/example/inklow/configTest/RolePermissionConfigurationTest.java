package com.example.inklow.configTest;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.daoImp.RolePermissionsDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RolePermissionConfigurationTest {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RolePermissionConfigurationTest(final @Qualifier("testJdbc") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean(name = "testRolePermissionConfig")
    public RolePermissionsDao rolePermissionsDao() {
        return new RolePermissionsDaoImp(jdbcTemplate);
    }
}