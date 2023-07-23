package project.vilsoncake.BookOnlineStore.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;
import project.vilsoncake.BookOnlineStore.entity.BookWarehouseEntity;
import project.vilsoncake.BookOnlineStore.repository.BookRepository;
import project.vilsoncake.BookOnlineStore.repository.WarehouseRepository;
import project.vilsoncake.BookOnlineStore.service.BookService;
import project.vilsoncake.BookOnlineStore.utils.ValidateUtils;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.BOOK_ALREADY_EXIST_MESSAGE;
import static project.vilsoncake.BookOnlineStore.constant.MessageConst.BOOK_NOT_FOUND_MESSAGE;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final WarehouseRepository warehouseRepository;

    public BookServiceImpl(BookRepository bookRepository, WarehouseRepository warehouseRepository) {
        this.bookRepository = bookRepository;
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public String addBook(BookEntity book, Integer setOfBooksCount, Model model) {
        if (bookRepository.findByIsbn(book.getIsbn()) != null) {
            model.addAttribute("bookExistError", BOOK_ALREADY_EXIST_MESSAGE);
            return "manager/book-data.html";
        }
        // Add book to warehouse
        BookWarehouseEntity bookWarehouse = new BookWarehouseEntity(book, setOfBooksCount);
        warehouseRepository.save(bookWarehouse);

        // Save new book
        book.setAvailability(true);
        bookRepository.save(book);

        return "manager/book-data.html";
    }

    @Override
    public String addToSetOfBooks(String id, Integer newSetCount, Model model) {
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

        BookWarehouseEntity bookWarehouse = warehouseRepository.findByBook(book);

        if (bookWarehouse == null) {
            model.addAttribute("bookError", BOOK_NOT_FOUND_MESSAGE);
            return "manager/book-data.html";
        }
        // Set new book count on warehouse
        bookWarehouse.setCount(bookWarehouse.getCount() + newSetCount);
        warehouseRepository.save(bookWarehouse);

        return "manager/book-data.html";
    }
}
