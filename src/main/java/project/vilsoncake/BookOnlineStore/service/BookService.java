package project.vilsoncake.BookOnlineStore.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;

import java.security.Principal;

public interface BookService {

    String getBook(String id, RedirectAttributes redirectAttributes, Principal principal, Model model);
    String addBook(BookEntity book, MultipartFile avatar, String issueYear, String page, String setOfBooksCount, Principal principal, Model model);
    String deleteBookById(Long id, RedirectAttributes redirectAttributes, Principal principal);
    String addToSetOfBooks(Long id, RedirectAttributes redirectAttributes, String newSetCount, Principal principal, Model model);
}
