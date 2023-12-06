package entity;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Kelsie", "kels@mail.utoronto.ca", "password",
                LocalDateTime.of(2023, 12, 1, 12,0,0),
                new Profile("Kelsie"));
    }

    @Test
    void getUsername() {
        assertEquals("Kelsie", user.getUsername());
    }
    @Test
    void getEmail() {
        assertEquals("kels@mail.utoronto.ca", user.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("password", user.getPassword());
    }

    @Test
    void getCreationTime() {
        assertEquals(LocalDateTime.of(2023, 12, 1, 12,0,0),
                user.getCreationTime());
    }

    @Test
    void testToString() {
        assertEquals("{" +
                "\"username\":" + '\"' + user.getUsername() + '\"' +
                ", \"email\":" + '\"' + user.getEmail() + '\"'
                + '}', user.toString());
        System.out.println(user.toString());
    }
}