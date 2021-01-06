package com.example.inklowTest.configTest;

import com.example.inklow.configuration.PasswordEncoderConfig;
import com.example.inklow.dao.UserDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.daoImp.UserDaoImp;
import com.example.inklowTest.databaseTest.DatabaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

@TestConfiguration
@Import({DatabaseTest.class,
        UserRoleConfigurationTest.class,
        PasswordEncoderConfig.class})
public class UserConfigurationTest {
    private final JdbcTemplate jdbcTemplate;
    private final UserRoleDao userRoleDao;

    @Autowired
    public UserConfigurationTest(final @Qualifier("testJdbc") JdbcTemplate jdbcTemplate,
                                 final @Qualifier("testUserRoleConfig") UserRoleDao userRoleDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRoleDao = userRoleDao;
    }

    @Bean(name = "testUserConfig")
    @Primary
    public UserDao userDao() {
        return new UserDaoImp(jdbcTemplate, userRoleDao);
    }
}
