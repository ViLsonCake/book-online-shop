package project.vilsoncake.BookOnlineStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;
import project.vilsoncake.BookOnlineStore.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final UserService userService;

    public ManagerController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/book-data")
    public String getBookInfoPage(@ModelAttribute("book") BookEntity book, Principal principal, Model model) {
        model.addAttribute("user", userService.getAuthenticatedUser(principal));
        return "manager/book-data.html";
    }

}
