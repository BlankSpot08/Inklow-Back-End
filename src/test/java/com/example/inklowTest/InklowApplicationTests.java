package com.example.inklowTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class InklowApplicationTests {
    @Test
    void BCrypt() {
        System.out.println(new BCryptPasswordEncoder().encode("Register08"));
    }
}
