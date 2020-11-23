package com.example.inklow;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.dao.UserDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.daoImp.UserDaoImp;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

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
}
