package project.vilsoncake.BookOnlineStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.vilsoncake.BookOnlineStore.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/get-user")
    public String getUserInfoPage() {
        return "admin/user-data.html";
    }

    @PostMapping("/get-user")
    public String findUser(@RequestParam String userId, Model model) {
        return adminService.findUser(userId, model);
    }

    @PutMapping
    public String changeRole(@RequestParam("id") Long userId, Model model) {
        return adminService.changeUserRole(userId, model);
    }

    @PatchMapping
    public String changeActivity(@RequestParam("id") Long userId, Model model) {
        return adminService.changeUserActive(userId, model);
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("id") Long id, Model model) {
        return adminService.deleteUser(id, model);
    }

}
