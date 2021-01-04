package com.example.inklowTest.configTest;

import com.example.inklow.dao.RolePermissionDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.daoImp.UserRoleDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UserRoleConfigurationTest {
    private final JdbcTemplate jdbcTemplate;
    private final RolePermissionDao rolePermissionDao;

    @Autowired
    public UserRoleConfigurationTest(final @Qualifier("testJdbc") JdbcTemplate jdbcTemplate, final @Qualifier("testRolePermissionConfig") RolePermissionDao rolePermissionDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.rolePermissionDao = rolePermissionDao;
    }

    @Bean(name = "testUserRoleConfig")
    public UserRoleDao userRoleDao() {
        return new UserRoleDaoImp(jdbcTemplate, rolePermissionDao);
    }
}
