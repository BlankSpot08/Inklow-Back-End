package com.example.inklow.configTest;

import com.example.inklow.dao.RoleDao;
import com.example.inklow.dao.RolePermissionDao;
import com.example.inklow.daoImp.RoleDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RoleConfigurationTest {
    private final JdbcTemplate jdbcTemplate;
    private final RolePermissionDao rolePermissionDao;

    @Autowired
    public RoleConfigurationTest(final @Qualifier("testJdbc") JdbcTemplate jdbcTemplate, final @Qualifier("testRolePermissionConfig") RolePermissionDao rolePermissionDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.rolePermissionDao = rolePermissionDao;
    }

    @Bean(name = "testRoleConfig")
    public RoleDao roleDao() {
        return new RoleDaoImp(jdbcTemplate, rolePermissionDao);
    }
}
