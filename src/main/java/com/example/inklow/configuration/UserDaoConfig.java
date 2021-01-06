package com.example.inklow.configuration;

import com.example.inklow.dao.UserDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.daoImp.UserDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UserDaoConfig {
    private final JdbcTemplate jdbcTemplate;
    private final UserRoleDao userRoleDao;

    @Autowired
    public UserDaoConfig(final JdbcTemplate jdbcTemplate, final UserRoleDao userRoleDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRoleDao = userRoleDao;
    }

    @Bean
    @Primary
    public UserDao userDao() {
        return new UserDaoImp(jdbcTemplate, userRoleDao);
    }
}
