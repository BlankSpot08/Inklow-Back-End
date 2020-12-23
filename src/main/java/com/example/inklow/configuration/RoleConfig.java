package com.example.inklow.configuration;

import com.example.inklow.dao.RoleDao;
import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.daoImp.RoleDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RoleConfig {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RolePermissionsDao rolePermissionsDao;

    @Bean
    public RoleDao roleDao() {
        return new RoleDaoImp(jdbcTemplate, rolePermissionsDao);
    }

}
