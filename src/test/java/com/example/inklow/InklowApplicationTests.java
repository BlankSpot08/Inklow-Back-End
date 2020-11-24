package com.example.inklow;

import com.example.inklow.dao.*;
import com.example.inklow.daoImp.UserDaoImp;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;
import com.example.inklow.model.AuthenticationRequest;
import com.example.inklow.security.Authentication;
import com.example.inklow.service.UserService;
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
	@Test
	void contextLoads() {

	}

	@Autowired
	private UserDao userDao;

	@Autowired
	private PermissionDao permissionDao;

	@Autowired
	private RoleDao roleDao;

	@Test
	void UserTest() {
		User user = userDao.findUserByUsername("BlankSpot08");

		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getGender());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		System.out.println(user.getPhoneNumber());
		System.out.println(user.getId());
		System.out.println(user.getBirthDate());

		for (Role role : user.getRoles()) {
			System.out.println(role.getName());
		}

		for (int i = 0; i < user.getRoles().size(); i++) {
			for (int j = 0; j < user.getRoles().get(i).getPermissions().size(); j++) {
				System.out.println(user.getRoles().get(i).getPermissions().get(j).getName());
			}
		}
	}

	@Test
	void PermissionTest() {
		List<Role> roles = roleDao.getListOfRole();

		for (Role role : roles) {
			System.out.println(role.getName());
			for (Permission permission : role.getPermissions()) {
				System.out.println(permission.getName());
			}
		}
	}
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void bCrypt() {
		System.out.println(passwordEncoder.encode("09194163795"));
	}

	@Autowired
	Authentication authentication;

	@Autowired
	UserService userService;

	@Test
	void authentication() {
		System.out.println("test");
		System.out.println(passwordEncoder.encode("09194163795"));
	}
}
