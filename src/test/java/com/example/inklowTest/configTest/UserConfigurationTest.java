package com.example.inklowTest.configTest;

import com.example.inklow.dao.UserDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.daoImp.UserDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfigurationTest {
    private final JdbcTemplate jdbcTemplate;
    private final UserRoleDao userRoleDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserConfigurationTest(final @Qualifier("testJdbc") JdbcTemplate jdbcTemplate, final @Qualifier("testUserRoleConfig") UserRoleDao userRoleDao, final PasswordEncoder passwordEncoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRoleDao = userRoleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean(name = "testUserConfig")
    public UserDao userDao() {
        return new UserDaoImp(jdbcTemplate, userRoleDao, passwordEncoder);
    }
}
