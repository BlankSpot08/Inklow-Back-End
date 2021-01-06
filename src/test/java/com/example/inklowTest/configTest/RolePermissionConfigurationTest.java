package com.example.inklowTest.configTest;

import com.example.inklow.dao.RolePermissionDao;
import com.example.inklow.daoImp.RolePermissionDaoImp;
import com.example.inklowTest.databaseTest.DatabaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Import(DatabaseTest.class)
public class RolePermissionConfigurationTest {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RolePermissionConfigurationTest(final @Qualifier("testJdbc") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean(name = "testRolePermissionConfig")
    public RolePermissionDao rolePermissionsDao() {
        return new RolePermissionDaoImp(jdbcTemplate);
    }
}