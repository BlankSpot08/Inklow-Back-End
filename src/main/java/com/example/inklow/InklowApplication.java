package com.example.inklow;

import com.example.inklow.dao.PermissionDao;
import com.example.inklow.dao.RoleDao;
import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.daoImp.PermissionDaoImp;
import com.example.inklow.daoImp.RoleDaoImp;
import com.example.inklow.daoImp.RolePermissionsDaoImp;
import com.example.inklow.daoImp.UserRoleDaoImp;
import com.example.inklow.service.UserService;
import com.example.inklow.serviceImp.UserServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InklowApplication {
	public static void main(String[] args) {
		SpringApplication.run(InklowApplication.class, args);
	}
}


