package com.example.inklow.configuration;

import com.example.inklow.dao.RolePermissionDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.daoImp.UserRoleDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UserRoleDaoConfig {
    private final JdbcTemplate jdbcTemplate;
    private final RolePermissionDao rolePermissionDao;

    @Autowired
    public UserRoleDaoConfig(final JdbcTemplate jdbcTemplate, final RolePermissionDao rolePermissionDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.rolePermissionDao = rolePermissionDao;
    }

    @Bean
    @Primary
    public UserRoleDao userRoleDao() {
        return new UserRoleDaoImp(jdbcTemplate, rolePermissionDao);
    }
}
