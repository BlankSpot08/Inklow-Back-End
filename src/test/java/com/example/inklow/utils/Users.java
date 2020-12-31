package com.example.inklow.utils;

import com.example.inklow.builder.UserBuilder;
import com.example.inklow.dao.UserDao;
import com.example.inklow.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class Users {
    private final UserDao userDao;

    @Autowired
    public Users(UserDao userDao) {
        this.userDao = userDao;
    }

    @Test
    void getUsers() {
        List<User> getUsers = userDao.getListOfUsers();

        getUsers.forEach(e -> {
            System.out.println(e.getId());
            System.out.println(e.getFirstName());
            System.out.println(e.getLastName());
            System.out.println(e.getGender());
            System.out.println(e.getEmail());
            System.out.println(e.getUsername());
            System.out.println(e.getPassword());
            System.out.println(e.getPhoneNumber());

            System.out.println("Roles: ");
            e.getRoles().forEach(j -> {
                System.out.println(j.getId());
                System.out.println(j.getName());
                System.out.println(j.getDescription());

                System.out.println("Permissions");
                j.getPermissions().forEach(k -> {
                    System.out.println(k.getId());
                    System.out.println(k.getName());
                    System.out.println(k.getDescription());
                });
            });
            System.out.println();
        });
    }

    @Test
    void insertUser() {
        String firstName = "";
        String lastName = "";
        String gender = "";
        Date birthDate = new Date("");
        String username = "";
        String password = "";
        String email = "";
        String phoneNumber = "";

        User user = new UserBuilder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .birthDate(birthDate)
                .username(username)
                .password(password)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();

        System.out.println(userDao.addUser(user));
    }

    @Test
    void deleteUser() {
        UUID id = UUID.fromString("");

        User user = new UserBuilder()
                .id(id)
                .build();

        System.out.println(userDao.removeUser(user));
    }
}
