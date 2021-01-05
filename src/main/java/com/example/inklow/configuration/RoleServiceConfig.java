package com.example.inklow.configuration;

import com.example.inklow.dao.RoleDao;
import com.example.inklow.service.RoleService;
import com.example.inklow.serviceImp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RoleServiceConfig {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceConfig(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Bean
    @Primary
    public RoleService roleService() {
        return new RoleServiceImp(roleDao);
    }
}
