package project.vilsoncake.BookOnlineStore.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;
import project.vilsoncake.BookOnlineStore.entity.BookWarehouseEntity;
import project.vilsoncake.BookOnlineStore.repository.BookRepository;
import project.vilsoncake.BookOnlineStore.service.AvatarService;
import project.vilsoncake.BookOnlineStore.service.BookService;
import project.vilsoncake.BookOnlineStore.service.WarehouseService;
import project.vilsoncake.BookOnlineStore.utils.ValidateUtils;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.BOOK_ALREADY_EXIST_MESSAGE;
import static project.vilsoncake.BookOnlineStore.constant.MessageConst.BOOK_NOT_FOUND_MESSAGE;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final WarehouseService warehouseService;
    private final AvatarService avatarService;

    public BookServiceImpl(BookRepository bookRepository, WarehouseService warehouseService, AvatarService avatarService) {
        this.bookRepository = bookRepository;
        this.warehouseService = warehouseService;
        this.avatarService = avatarService;
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
    public String addBook(BookEntity book, MultipartFile avatar, Integer setOfBooksCount, Model model) {
        if (bookRepository.findByIsbn(book.getIsbn()) != null) {
            model.addAttribute("bookExistError", BOOK_ALREADY_EXIST_MESSAGE);
            return "manager/book-data.html";
        }

        // Save new book
        book.setAvailability(true);
        bookRepository.save(book);
        log.info("Book {} added", book.getName());

        // Add book to warehouse
        warehouseService.addBookToWarehouse(book, setOfBooksCount);

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
