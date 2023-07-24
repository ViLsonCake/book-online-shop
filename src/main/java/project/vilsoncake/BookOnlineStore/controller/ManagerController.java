package project.vilsoncake.BookOnlineStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping("/book-data")
    public String getBookInfoPage(@ModelAttribute("book") BookEntity book) {
        return "manager/book-data.html";
    }

}
