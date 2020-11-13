package com.example.inklow;

import com.example.inklow.dao.RolePermissionsDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class InklowApplicationTests {
	@Autowired
	private UserRoleDao userRoleDao;

	@Autowired
	private RolePermissionsDao rolePermissionsDao;

	@Test
	void rolePermissions() {
		List<Permission> sad = rolePermissionsDao.getRolePermissionsById(UUID.fromString("e4ddc912-3a88-49da-ac04-b83171521dd5"));

		for (Permission permission : sad) {
			System.out.println(permission.getId());
			System.out.println(permission.getName());
			System.out.println(permission.getDescription());
			System.out.println();
		}
	}

	@Test
	void contextLoads() {
		System.out.println("Testing");
		List<Role> sad = userRoleDao.getUserRolesById(UUID.fromString("cee3a79a-5192-4b8d-9fec-00d44c1aaed9"));
		System.out.println(sad);
		for (Role role : sad) {
			System.out.println(role.getId());
			System.out.println(role.getName());
			System.out.println(role.getDescription());
			System.out.println();
		}
	}
}
