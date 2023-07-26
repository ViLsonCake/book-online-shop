package project.vilsoncake.BookOnlineStore.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BookUtilsTest {

    private final BookUtils bookUtils;

    @Autowired
    BookUtilsTest(BookUtils bookUtils) {
        this.bookUtils = bookUtils;
    }

    @Test
    void isValidAuthor() {
        assertTrue(bookUtils.isValidAuthor("George Orwell"));
        assertFalse(bookUtils.isValidAuthor("George Orwell Example"));
        assertFalse(bookUtils.isValidAuthor("George2 Orwell"));
        assertFalse(bookUtils.isValidAuthor("george"));
    }

    @Test
    void isValidLanguage() {
        assertTrue(bookUtils.isValidLanguage("English"));
        assertTrue(bookUtils.isValidLanguage("Polish"));
        assertFalse(bookUtils.isValidLanguage("Polish12"));
    }

    @Test
    void isValidBinding() {
        assertTrue(bookUtils.isValidBinding("softcover"));
        assertTrue(bookUtils.isValidBinding("hardcover"));
        assertFalse(bookUtils.isValidBinding("example"));
    }

    @Test
    void isValidIsbn() {
        assertTrue(bookUtils.isValidIsbn("978-0-9767736-6-5"));
        assertTrue(bookUtils.isValidIsbn("0-9767736-6-4"));
        assertFalse(bookUtils.isValidIsbn("0-9767736-6-42"));
    }
}