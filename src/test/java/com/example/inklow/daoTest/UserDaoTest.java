package com.example.inklow.daoTest;

import com.example.inklow.dao.UserDao;
import com.example.inklow.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class UserDaoTest {
    private final UserDao userDao;

    @Autowired
    public UserDaoTest(final @Qualifier("testUserConfig") UserDao userDao) {
        this.userDao = userDao;
    }

    @Test
    void findUserById() {
        UUID id = UUID.fromString("ce627f59-c377-4bfc-8d7b-8aded0c6ccd8");

        User user = userDao.findUserById(id);

        System.out.println(user.getId());
        System.out.println(user.getFirstName());
        System.out.println(user.getPassword());
        System.out.println(user.getGender());
        System.out.println(user.getBirthDate());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        System.out.println(user.getPhoneNumber());

        Assertions.assertNotNull(user);
    }

    @Test
    void findUserByUsername() {
        String username = "BlankSpot08";

        User user = userDao.findUserByUsername(username);

        System.out.println(user.getId());
        System.out.println(user.getFirstName());
        System.out.println(user.getPassword());
        System.out.println(user.getGender());
        System.out.println(user.getBirthDate());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        System.out.println(user.getPhoneNumber());

        Assertions.assertNotNull(user);
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

        Assertions.assertNotNull(getUsers);
    }

    @Test
    void insertUser() {
        String firstName = "Blank";
        String lastName = "Spot";
        String gender = "Female";
        Date birthDate = java.sql.Date.valueOf(LocalDate.parse("1998-12-01"));
        String username = "Blanker";
        String password = "09997874755";
        String email = "arvinchu21@gmail.com";
        String phoneNumber = "09958214987";

//        String firstName = "Arvin";
//        String lastName = "Chu";
//        String gender = "Male";
//        Date birthDate = java.sql.Date.valueOf(LocalDate.parse("2000-12-30"));
//        String username = "BlankSpot08";
//        String password = "09194163795";
//        String email = "arvinchu31@gmail.com";
//        String phoneNumber = "09997874755";

        User user = new User.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .birthDate(birthDate)
                .username(username)
                .password(password)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();

        Assertions.assertNotNull(userDao.addUser(user));
    }

    @Test
    void deleteUser() {
        UUID id = UUID.fromString("66e22b03-97ba-47a8-a0b4-02f049b8db01");

        User user = new User.Builder()
                .id(id)
                .build();

        Assertions.assertNotNull(userDao.removeUser(user));
    }

    @Test
    void deleteAllUser() {
        Assertions.assertNotNull(userDao.removeAllUser());
    }
}
