package project.vilsoncake.BookOnlineStore.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/get-user")
    public String getUserPage() {
        return "admin/user-data.html";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/get-user")
    public String findUser(@RequestParam String userId, Model model) {
        return adminService.findUser(userId, model);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/change-role")
    public String changeRole(@RequestParam("id") Long userId, Model model) {
        return adminService.changeUserRole(userId, model);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/block-user")
    public String changeActivity(@RequestParam("id") Long userId, Model model) {
        return adminService.changeUserActive(userId, model);
    }

}
