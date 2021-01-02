package com.example.inklow.daoTest;

import com.example.inklow.dao.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRoleDaoTest {
    private final UserRoleDao userRoleDao;

    @Autowired
    public UserRoleDaoTest(@Qualifier("testUserRoleConfig") UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }
}
