package com.example.inklow.daoImp;

import com.example.inklow.dao.RoleDao;
import com.example.inklow.dao.UserDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserRoleDao userRoles;

    @Override
    public User findUserById(UUID id) {
        String query = "SELECT * FROM users WHERE id = ?";

        System.out.println("jdbctemplate" + jdbcTemplate);

        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?;";

        User user = jdbcTemplate.queryForObject(query, new Object[] {username}, (rs, rowNum) -> new User(
                UUID.fromString(rs.getString("id")),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getString("gender"),
                rs.getDate("birthDate"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("phoneNumber"),
                userRoles.getUserRolesById(UUID.fromString(rs.getString("id")))
        ));

        List<Role> set = userRoles.getUserRolesById(UUID.fromString("cee3a79a-5192-4b8d-9fec-00d44c1aaed9"));

        return user;
    }

    @Override
    public List<User> getListOfUsers() {
        return null;
    }
}
