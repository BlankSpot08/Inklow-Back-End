package com.example.inklow.daoImp;

import com.example.inklow.dao.ReportInquiryDao;
import com.example.inklow.dao.UserDao;
import com.example.inklow.dao.UserRoleDao;
import com.example.inklow.entities.ReportInquiry;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;
import com.example.inklow.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserDaoImp implements UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final UserRoleDao userRoles;
//    private final ReportInquiryDao reportInquiryDao;

    @Autowired
    public UserDaoImp(final JdbcTemplate jdbcTemplate, final UserRoleDao userRoles) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRoles = userRoles;
//        this.reportInquiryDao = reportInquiryDao;
    }

    @Override
    public User findUserById(UUID id) {
        String query = "SELECT * FROM users WHERE id = ?";

        User user = jdbcTemplate.queryForObject(query, new Object[] {id}, new UserMapper());

        if (user == null) {
            return null;
        }

        List<Role> roles = userRoles.getUserRolesByUserId(user.getId());
        user.setRoles(roles);

        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?;";

        User user = jdbcTemplate.queryForObject(query, new Object[] {username}, new UserMapper());

        if (user == null) {
            return null;
        }

        List<Role> roles = userRoles.getUserRolesByUserId(user.getId());
        user.setRoles(roles);

//        List<ReportInquiry> reportInquiries =

        return user;
    }

    @Override
    public List<User> getListOfUsers() {
        String query = "SELECT * FROM users";

        List<User> users = jdbcTemplate.query(query, new UserMapper());

        for (User user : users) {
            List<Role> roles = userRoles.getUserRolesByUserId(user.getId());
            user.setRoles(roles);
        }

        return users;
    }

    @Override
    public User addUser(User user) {
        String query = "INSERT INTO users (firstName, lastName, gender, birthDate, username, password, email, phoneNumber) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        int statusCode = jdbcTemplate.update(query,
                user.getFirstName(), user.getLastName(), user.getGender(), user.getBirthDate(),
                user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNumber());

        if (statusCode == 0) {
            return null;
        }

        return user;
    }

    @Override
    public User removeUser(User user) {
        String query = "DELETE FROM users WHERE id = ?";

        int statusCode = jdbcTemplate.update(query, user.getId());

        if (statusCode == 0) {
            return null;
        }

        return user;
    }

    @Override
    public User updateUser(User user) {
        String query = "UPDATE user " +
                "SET firstName = ?, lastName = ?, username = ?, email = ?, phoneNumber = ? " +
                "WHERE id = ?";

        int statusCode = jdbcTemplate.update(query,
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail(),
                user.getPhoneNumber());

        if (statusCode == 0) {
            return null;
        }

        return user;
    }

    @Override
    public Boolean removeAllUser() {
        String query = "DELETE FROM users";

        int statusCode = jdbcTemplate.update(query);

        if (statusCode == 0) {
            return null;
        }

        return true;
    }
}
