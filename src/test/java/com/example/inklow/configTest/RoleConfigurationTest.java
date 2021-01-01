package com.example.inklow.configTest;

import com.example.inklow.dao.RoleDao;
import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.daoImpTest.RoleDaoImpTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RoleConfigurationTest {
    private final JdbcTemplate jdbcTemplate;
    private final RolePermissionsDao rolePermissionsDao;

    @Autowired
    public RoleConfigurationTest(final @Qualifier("testJdbc") JdbcTemplate jdbcTemplate, final @Qualifier("testRolePermissionConfig") RolePermissionsDao rolePermissionsDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.rolePermissionsDao = rolePermissionsDao;
    }

    @Bean(name = "testRoleConfig")
    public RoleDao roleDao() {
        return new RoleDaoImpTest(jdbcTemplate, rolePermissionsDao);
    }
}
