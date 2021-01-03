package com.example.inklow.configuration;

import com.example.inklow.dao.RoleDao;
import com.example.inklow.dao.RolePermissionDao;
import com.example.inklow.daoImp.RoleDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RoleDaoConfig {
    private final JdbcTemplate jdbcTemplate;
    private final RolePermissionDao rolePermissionDao;

    @Autowired
    public RoleDaoConfig(final JdbcTemplate jdbcTemplate, final RolePermissionDao rolePermissionDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.rolePermissionDao = rolePermissionDao;
    }

    @Bean
    @Primary
    public RoleDao roleDao() {
        return new RoleDaoImp(jdbcTemplate, rolePermissionDao);
    }

}
