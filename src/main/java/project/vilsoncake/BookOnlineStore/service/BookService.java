package project.vilsoncake.BookOnlineStore.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;

public interface BookService {

    String addBook(BookEntity book, MultipartFile avatar, Integer setOfBooksCount, Model model);
    String addToSetOfBooks(String id, Integer newSetCount, Model model);
}
