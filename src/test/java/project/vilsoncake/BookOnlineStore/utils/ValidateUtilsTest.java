package project.vilsoncake.BookOnlineStore.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateUtilsTest {

    @Test
    void isNumeric() {
        assertTrue(ValidateUtils.isNumeric("34"));
        assertTrue(ValidateUtils.isNumeric("3444442"));
        assertTrue(ValidateUtils.isNumeric("1"));
        assertFalse(ValidateUtils.isNumeric("test12@gmail.com"));
        assertFalse(ValidateUtils.isNumeric("12e"));
    }
}