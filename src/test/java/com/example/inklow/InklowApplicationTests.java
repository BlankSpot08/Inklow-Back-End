package com.example.inklow;

import com.example.inklow.dao.*;
import com.example.inklow.daoImp.UserDaoImp;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;
import com.example.inklow.model.AuthenticationRequest;
import com.example.inklow.security.Authentication;
import com.example.inklow.service.UserService;
import com.example.inklow.serviceImp.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class InklowApplicationTests {
	@Autowired
	UserServiceImp serviceImp;

	@Test
	void contextLoads() {
		serviceImp.getListOfUsers();
	}
}
