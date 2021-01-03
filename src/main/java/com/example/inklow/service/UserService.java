package com.example.inklow.service;

import com.example.inklow.entities.User;
import com.example.inklow.model.AuthenticationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    List<User> getListOfUsers();

    User findUserById(UUID id);
    User findUserByUsername(String username);

    String handleLogin(AuthenticationRequest authenticationRequest);
    User handleAccountRegistration(User user);

    User handleAccountDeletion(User user);
}
