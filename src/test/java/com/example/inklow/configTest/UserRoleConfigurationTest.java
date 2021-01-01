package com.example.inklow.configTest;

import com.example.inklow.dao.RolePermissionsDao;
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
    private final RolePermissionsDao rolePermissionsDao;

    @Autowired
    public UserRoleConfigurationTest(final @Qualifier("testJdbc") JdbcTemplate jdbcTemplate, final @Qualifier("testRolePermissionConfig") RolePermissionsDao rolePermissionsDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.rolePermissionsDao = rolePermissionsDao;
    }

    @Bean(name = "testUserRoleConfig")
    public UserRoleDao userRoleDao() {
        return new UserRoleDaoImp(jdbcTemplate, rolePermissionsDao);
    }
}
