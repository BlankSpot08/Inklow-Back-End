package com.example.inklow.configTest;

import com.example.inklow.dao.PermissionDao;
import com.example.inklow.daoImp.PermissionDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class PermissionConfigurationTest {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PermissionConfigurationTest(final @Qualifier("testJdbc") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean(name = "testPermissionConfig")
    public PermissionDao permissionDao() {
        return new PermissionDaoImp(jdbcTemplate);
    }
}
