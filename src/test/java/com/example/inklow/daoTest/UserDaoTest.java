package com.example.inklow.daoTest;

import com.example.inklow.builder.UserBuilder;
import com.example.inklow.dao.UserDao;
import com.example.inklow.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
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
        String firstName = "Arvin";
        String lastName = "Chu";
        String gender = "Male";
        LocalDate birthDate = LocalDate.parse("2000-12-30");
        String username = "BlankSpot08";
        String password = "09194163795";
        String email = "arvinchu31@gmail.com";
        String phoneNumber = "09997874755";

        User user = new UserBuilder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
//                .birthDate(birthDate)
                .username(username)
                .password(password)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();

        Assertions.assertNotNull(userDao.addUser(user));
    }

    @Test
    void deleteUser() {
        UUID id = UUID.fromString("2d81ef89-808e-4f91-83f9-841413828f54");

        User user = new UserBuilder()
                .id(id)
                .build();

        Assertions.assertNotNull(userDao.removeUser(user));
    }


}
