package project.vilsoncake.BookOnlineStore.service;

import org.springframework.ui.Model;

public interface AdminService {

    String findUser(String userId, Model model);
    String changeUserActive(String userId);
}
