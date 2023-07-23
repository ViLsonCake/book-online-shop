package project.vilsoncake.BookOnlineStore.service;

import org.springframework.ui.Model;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;

public interface BookService {

    String addBook(BookEntity book, Integer setOfBooksCount, Model model);
    String addToSetOfBooks(String id, Integer newSetCount, Model model);
}
