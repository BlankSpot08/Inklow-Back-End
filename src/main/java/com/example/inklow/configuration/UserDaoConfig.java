package com.example.inklow.configuration;

import com.example.inklow.dao.UserDao;
import com.example.inklow.dao.UserReportInquiryDao;
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
    private final UserReportInquiryDao userReportInquiryDao;

    @Autowired
    public UserDaoConfig(
            final JdbcTemplate jdbcTemplate,
            final UserRoleDao userRoleDao,
            final UserReportInquiryDao userReportInquiryDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRoleDao = userRoleDao;
        this.userReportInquiryDao = userReportInquiryDao;
    }

    @Bean
    @Primary
    public UserDao userDao() {
        return new UserDaoImp(jdbcTemplate, userRoleDao, userReportInquiryDao);
    }
}
