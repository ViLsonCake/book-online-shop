package project.vilsoncake.BookOnlineStore.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;
import project.vilsoncake.BookOnlineStore.entity.BookWarehouseEntity;
import project.vilsoncake.BookOnlineStore.repository.BookRepository;
import project.vilsoncake.BookOnlineStore.service.AvatarService;
import project.vilsoncake.BookOnlineStore.service.BookService;
import project.vilsoncake.BookOnlineStore.service.WarehouseService;
import project.vilsoncake.BookOnlineStore.utils.BookUtils;
import project.vilsoncake.BookOnlineStore.utils.ValidateUtils;

import java.util.Map;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.BOOK_NOT_FOUND_MESSAGE;
import static project.vilsoncake.BookOnlineStore.utils.ValidateUtils.hasErrors;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final WarehouseService warehouseService;
    private final AvatarService avatarService;
    private final BookUtils bookUtils;

    public BookServiceImpl(BookRepository bookRepository, WarehouseService warehouseService, AvatarService avatarService, BookUtils bookUtils) {
        this.bookRepository = bookRepository;
        this.warehouseService = warehouseService;
        this.avatarService = avatarService;
        this.bookUtils = bookUtils;
    }

    @Transactional
    @Override
    public String getBook(String id, RedirectAttributes redirectAttributes, Model model) {
        BookEntity book;
        if (ValidateUtils.isNumeric(id)) {
            book = bookRepository.findById(Long.parseLong(id)).isPresent() ?
                    bookRepository.findById(Long.parseLong(id)).get() : null;
        } else {
            book = bookRepository.findByIsbn(id);
        }

        if (book == null) {
            model.addAttribute("bookError", BOOK_NOT_FOUND_MESSAGE);
            return "manager/book-data.html";
        }

        redirectAttributes.addAttribute("book", book);
        return "redirect:/manager/book-data";
    }

    @Transactional
    @Override
    public String addBook(BookEntity book, MultipartFile avatar, String issueYear, String page, String startCount, Model model) {
        // Get map with error messages
        Map<String, String> validateBook = bookUtils.isValidBook(book, issueYear, page, startCount, avatar);

        if (hasErrors(validateBook)) {
            model.addAllAttributes(validateBook);
            model.addAllAttributes(bookUtils.bookToMap(book, issueYear, page, startCount));
            return "manager/book-data.html";
        }
        // Convert string values to int
        Integer convertIssueYear = Integer.parseInt(issueYear);
        Integer convertPage = Integer.parseInt(page);
        Integer convertStartCount = Integer.parseInt(startCount);

        // Save new book
        book.setIssueYear(convertIssueYear);
        book.setPage(convertPage);
        book.setAvailability(true);
        bookRepository.save(book);
        log.info("Book {} added", book.getName());

        // Add book to warehouse
        warehouseService.addBookToWarehouse(book, convertStartCount);

        // Add avatar to book
        avatarService.addAvatar(book, avatar);

        return "manager/book-data.html";
    }
    @Override
    public String addToSetOfBooks(String id, RedirectAttributes redirectAttributes, Integer newSetCount, Model model) {
        BookEntity book;
        if (ValidateUtils.isNumeric(id)) {
            book = bookRepository.findById(Long.parseLong(id)).isPresent() ?
                    bookRepository.findById(Long.parseLong(id)).get() : null;
        } else {
            book = bookRepository.findByIsbn(id);
        }

        if (book == null) {
            model.addAttribute("bookError", BOOK_NOT_FOUND_MESSAGE);
        }

        BookWarehouseEntity bookWarehouse = warehouseService.getBookWarehouse(book);

        if (bookWarehouse == null) {
            model.addAttribute("bookError", BOOK_NOT_FOUND_MESSAGE);
            return "manager/book-data.html";
        }
        // Set new book count on warehouse
        warehouseService.changeBooksCount(book, newSetCount);

        redirectAttributes.addAttribute("book", book);
        return "redirect:/manager/book-data";
    }
}
