package project.vilsoncake.BookOnlineStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;
import project.vilsoncake.BookOnlineStore.service.BookService;

@Controller
public class ManagerController {

    private final BookService bookService;

    public ManagerController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/manager/book-data")
    public String getBookInfoPage() {
        return "manager/book-data.html";
    }

    @PostMapping("/books")
    public String saveNewBook(
            @RequestParam String name,
            @RequestParam String author,
            @RequestParam String publisher,
            @RequestParam Integer yearOfIssue,
            @RequestParam Integer page,
            @RequestParam String language,
            @RequestParam String binding,
            @RequestParam String description,
            @RequestParam String isbn,
            @RequestParam String category,
            @RequestParam Integer startCount,
            @RequestParam MultipartFile avatar,
            Model model
            ) {
        System.out.println(startCount);
        System.out.println(avatar.getOriginalFilename());
        return bookService.addBook(
                new BookEntity(
                        name.trim(),
                        author.trim(),
                        publisher.trim(),
                        yearOfIssue,
                        page,
                        language.trim(),
                        binding.trim(),
                        description.trim(),
                        isbn.trim(),
                        category.trim()
                ), avatar, startCount, model
        );
    }

    @PutMapping("/books")
    public String changeBooksCount(@RequestParam String id, @RequestParam Integer count, Model model) {
        return bookService.addToSetOfBooks(id, count, model);
    }
}
