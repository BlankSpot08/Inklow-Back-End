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
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PermissionDao permissionDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
	}

	@Test
	void getUsers() {

		List<User> getUsers = userDao.getListOfUsers();

		getUsers.forEach(e -> {
			System.out.println(e.getFirstName());
			System.out.println(e.getLastName());
			System.out.println(e.getGender());
			System.out.println(e.getEmail());
			System.out.println(e.getUsername());
			System.out.println(e.getPassword());
			System.out.println(e.getPhoneNumber());

			System.out.println("Roles: ");
			e.getRoles().forEach(j -> {
				System.out.println(j.getId());
				System.out.println(j.getName());
				System.out.println(j.getDescription());

				System.out.println("Permissions");
				j.getPermissions().forEach(k -> {
					System.out.println(k.getId());
					System.out.println(k.getName());
					System.out.println(k.getDescription());
				});
			});
		});
	}


	@Test
	void getPermissions() {
		permissionDao.getListOfPermission().forEach(e -> {
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(e.getDescription());
			System.out.println();
		});
	}
}
