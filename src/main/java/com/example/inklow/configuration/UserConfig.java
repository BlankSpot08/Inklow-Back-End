package com.example.inklow.configuration;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.dao.UserDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.daoImp.UserDaoImp;
import com.example.inklow.security.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {
    private final JdbcTemplate jdbcTemplate;
    private final UserRoleDao userRoleDao;
    private final PasswordEncoder passwordEncoder;

    public UserConfig(JdbcTemplate jdbcTemplate, UserRoleDao userRoleDao, PasswordEncoder passwordEncoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRoleDao = userRoleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImp(jdbcTemplate, userRoleDao, passwordEncoder);
    }
}
