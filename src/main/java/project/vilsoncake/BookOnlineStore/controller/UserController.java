package project.vilsoncake.BookOnlineStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.vilsoncake.BookOnlineStore.entity.AddressEntity;
import project.vilsoncake.BookOnlineStore.entity.UserEntity;
import project.vilsoncake.BookOnlineStore.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration.html";
    }

    @PostMapping
    public String addUser(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            @RequestParam String country,
            @RequestParam String city,
            @RequestParam String street,
            @RequestParam String postalCode,
            Model model
    ) {
        return userService.addUser(
                new UserEntity(
                        firstName.trim(),
                        lastName.trim(),
                        email.trim(),
                        password.trim(),
                        phoneNumber.trim()
                ),
                new AddressEntity(
                        country.trim(),
                        city.trim(),
                        postalCode.trim(),
                        street.trim()
                ),
                confirmPassword,
                model
        );
    }
}
