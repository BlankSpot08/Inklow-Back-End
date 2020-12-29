package com.example.inklow.configuration;

import com.example.inklow.dao.RoleDao;
import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.daoImp.RoleDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RoleConfig {
    private final JdbcTemplate jdbcTemplate;
    private final RolePermissionsDao rolePermissionsDao;

    @Autowired
    public RoleConfig(final JdbcTemplate jdbcTemplate, final RolePermissionsDao rolePermissionsDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.rolePermissionsDao = rolePermissionsDao;
    }

    @Bean
    @Primary
    public RoleDao roleDao() {
        return new RoleDaoImp(jdbcTemplate, rolePermissionsDao);
    }

}
