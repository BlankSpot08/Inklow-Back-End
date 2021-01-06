package com.example.inklowTest.configTest;

import com.example.inklow.dao.RoleDao;
import com.example.inklow.dao.RolePermissionDao;
import com.example.inklow.daoImp.RoleDaoImp;
import com.example.inklowTest.databaseTest.DatabaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

@TestConfiguration
@Import({DatabaseTest.class,
        RolePermissionConfigurationTest.class})
public class RoleConfigurationTest {
    private final JdbcTemplate jdbcTemplate;
    private final RolePermissionDao rolePermissionDao;

    @Autowired
    public RoleConfigurationTest(final @Qualifier("testJdbc") JdbcTemplate jdbcTemplate,
                                 final @Qualifier("testRolePermissionConfig") RolePermissionDao rolePermissionDao) {

        this.jdbcTemplate = jdbcTemplate;
        this.rolePermissionDao = rolePermissionDao;
    }

    @Bean(name = "testRoleConfig")
    public RoleDao roleDao() {
        return new RoleDaoImp(jdbcTemplate, rolePermissionDao);
    }
}
