package project.vilsoncake.BookOnlineStore.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;

public interface BookService {

    String getBook(String id, RedirectAttributes redirectAttributes, Model model);
    String addBook(BookEntity book, MultipartFile avatar, Integer setOfBooksCount, Model model);
    String addToSetOfBooks(String id, RedirectAttributes redirectAttributes, Integer newSetCount, Model model);
}
