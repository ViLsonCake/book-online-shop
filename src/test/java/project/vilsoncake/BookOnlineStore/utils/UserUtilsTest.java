package project.vilsoncake.BookOnlineStore.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserUtilsTest {

    private final UserUtils userUtils;

    @Autowired
    UserUtilsTest(UserUtils userUtils) {
        this.userUtils = userUtils;
    }

    @Test
    void isValidEmail() {
        assertTrue(userUtils.isValidEmail("example@gmail.com"));
        assertTrue(userUtils.isValidEmail("example123@gmail.com"));
        assertTrue(userUtils.isValidEmail("peter.parker@zylker.com"));
        assertFalse(userUtils.isValidEmail("aa@some.coom"));
    }

    @Test
    void isValidPassword() {
        assertTrue(userUtils.isValidPassword("Password1!"));
        assertTrue(userUtils.isValidPassword("qwertyQ56#"));
        assertFalse(userUtils.isValidPassword("pass"));
        assertFalse(userUtils.isValidPassword("Password4"));
    }
}