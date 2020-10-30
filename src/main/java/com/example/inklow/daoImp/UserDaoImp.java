package com.example.inklow.daoImp;

import com.example.inklow.dao.UserDao;
import com.example.inklow.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // Read
    @Override
    public List<User> getUsers() {
        String query = "SELECT * FROM users";

        List<User> listOfUsers = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));

        return listOfUsers;
    }

    // Create
    @Override
    public User addUser(User user) {
        String query = "INSERT INTO users(firstName, lastName, gender, birthDate, username, password, email, phoneNumber) VALUES (?, ? , ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getGender(), user.getBirthDate(), user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNumber());

        return user;
    }

    @Override
    public User removeUser(User user) {
        String query = "DELETE FROM users WHERE id = ?";

        jdbcTemplate.update(query, user.getId());

        return user;
    }

    @Override
    public User updateUser(User user) {
        String query = "UPDATE users SET firstName = ?, lastName = ?, username = ?, password = ?, email = ?, phoneNumber = ? WHERE id = ?";

        jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNumber(), user.getId());

        return user;
    }
}
