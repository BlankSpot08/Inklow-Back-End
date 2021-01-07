package com.example.inklow.serviceImp;

import com.example.inklow.dao.UserDao;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;
import com.example.inklow.entities.UserRole;
import com.example.inklow.model.AuthenticationRequest;
import com.example.inklow.security.Authentication;
import com.example.inklow.service.RoleService;
import com.example.inklow.service.UserRoleService;
import com.example.inklow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final Authentication authentication;
    private final UserRoleService userRoleService;
    private final RoleService roleService;

    @Autowired
    public UserServiceImp(Authentication authentication, UserDao userDao, PasswordEncoder passwordEncoder, UserRoleService userRoleService, RoleService roleService) {
        this.authentication = authentication;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.userRoleService = userRoleService;
        this.roleService = roleService;
    }

    @Override
    public List<User> getListOfUsers() {
        return userDao.getListOfUsers();
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
    public User handleAccountRegistration(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User tempUser = userDao.addUser(user);
        tempUser = userDao.findUserByUsername(tempUser.getUsername());

        Role role = roleService.getRoleByName("User");

        UserRole userRole = new UserRole.Builder()
                .userId(tempUser.getId())
                .roleId(role.getId())
                .build();

        userRoleService.handleUserRoleRegistration(userRole);

        return tempUser;
    }

    @Override
    public User handleAccountDeletion(User user) {
        return userDao.removeUser(user);
    }

    @Override
    public Boolean handleAllAccountDeletion() {
        return userDao.removeAllUser();
    }

    @Override
    public User handleAccountChanges(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int userCount() {
        return getListOfUsers().size();
    }
}
