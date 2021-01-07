package com.example.inklow.configuration;

import com.example.inklow.dao.UserDao;
import com.example.inklow.security.Authentication;
import com.example.inklow.service.RoleService;
import com.example.inklow.service.UserRoleService;
import com.example.inklow.service.UserService;
import com.example.inklow.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserServiceConfig {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final Authentication authentication;
    private final UserRoleService userRoleService;
    private final RoleService roleService;

    @Autowired
    public UserServiceConfig(final Authentication authentication,
                             final UserDao userDao,
                             final PasswordEncoder passwordEncoder,
                             final UserRoleService userRoleService,
                             final RoleService roleService) {
        this.authentication = authentication;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.userRoleService = userRoleService;
        this.roleService = roleService;
    }

    @Bean()
    @Primary
    public UserService userService() {
        return new UserServiceImp(authentication, userDao, passwordEncoder, userRoleService, roleService);
    }
}
