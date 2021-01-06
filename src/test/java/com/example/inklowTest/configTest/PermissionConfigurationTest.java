package com.example.inklowTest.configTest;

import com.example.inklow.dao.PermissionDao;
import com.example.inklow.daoImp.PermissionDaoImp;
import com.example.inklowTest.databaseTest.DatabaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

@TestConfiguration
@Import(DatabaseTest.class)
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
