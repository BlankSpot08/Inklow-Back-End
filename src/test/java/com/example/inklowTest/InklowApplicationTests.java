package com.example.inklowTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@SpringBootConfiguration
class InklowApplicationTests {
    @Test
    void BCrypt() {
        System.out.println(new BCryptPasswordEncoder().encode("Register08"));
    }
}
