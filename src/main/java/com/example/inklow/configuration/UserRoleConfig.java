package com.example.inklow.configuration;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.daoImp.UserRoleDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UserRoleConfig {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RolePermissionsDao rolePermissionsDao;

    @Bean
    public UserRoleDao userRoleDao() {
        return new UserRoleDaoImp(jdbcTemplate, rolePermissionsDao);
    }
}
