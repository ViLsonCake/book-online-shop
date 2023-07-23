package project.vilsoncake.BookOnlineStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.vilsoncake.BookOnlineStore.service.BookService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final BookService bookService;

    public ManagerController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book-data")
    public String getBookInfoPage() {
        return "manager/book-data.html";
    }

    @PostMapping("/books")
    public String saveNewBook() {
        return null;
    }

    @PutMapping("/books")
    public String changeBooksCount(@RequestParam String id, @RequestParam Integer count, Model model) {
        return bookService.addToSetOfBooks(id, count, model);
    }
}
