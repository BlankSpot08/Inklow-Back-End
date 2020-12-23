package com.example.inklow.serviceImp;

import com.example.inklow.builder.UserBuilder;
import com.example.inklow.dao.UserDao;
import com.example.inklow.entities.User;
import com.example.inklow.model.AuthenticationRequest;
import com.example.inklow.security.Authentication;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {
    private final Authentication authentication;
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(Authentication authentication, UserDao userDao, PasswordEncoder passwordEncoder) {
        this.authentication = authentication;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getListOfUsers() {
        List<User> test = List.of(new UserBuilder().username("BlankSpot08").password("09194163795").build(), new UserBuilder().build());
        return test;
//        return userDao.getListOfUsers();
    }

    @Override
    public User findUserById(UUID id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public String handleLogin(AuthenticationRequest authenticationRequest) {
        String jwt = authentication.authenticate(authenticationRequest);

        return jwt;
    }

    @Override
    public User handleRegister(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User tempUser = userDao.addUser(user);

        return tempUser;
    }
}
