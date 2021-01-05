package com.example.inklow.dataSeeds;

import com.example.inklow.entities.User;
import com.example.inklow.service.UserService;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class UserDataSeeds implements ApplicationRunner {
    private final UserService userService;

    @Autowired
    public UserDataSeeds(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadUserDatabaseData();
    }

    private void loadUserDatabaseData() {
        if (userService.userCount() == 0) {
            User defaultUser = new User.Builder()
                    .firstName("Arvin")
                    .lastName("Chu")
                    .birthDate(Date.valueOf(LocalDate.parse("2000-12-30")))
                    .gender("Male")
                    .username("BlankSpot08")
                    .password("09194163795")
                    .email("arvinchu31@gmail.com")
                    .build();

            userService.handleAccountRegistration(defaultUser);
        }
    }
}
