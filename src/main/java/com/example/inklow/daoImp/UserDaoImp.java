package com.example.inklow.daoImp;

import com.example.inklow.dao.UserDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;
import com.example.inklow.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRoleDao userRoles;

    @Override
    public User findUserById(UUID id) {
        String query = "SELECT * FROM users WHERE id = ?";

        System.out.println("jdbctemplate" + jdbcTemplate);

        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?;";

        User user = jdbcTemplate.queryForObject(query, new Object[] {username}, new UserMapper());

        List<Role> roles = userRoles.getUserRolesByUserId(user.getId());
        user.setRoles(roles);

        return user;
    }

    @Override
    public List<User> getListOfUsers() {
        return null;
    }

    @Override
    public User addUser(User user) {
        String query = "INSERT INTO users";

        jdbcTemplate.update(query);
        return user;
    }
}
