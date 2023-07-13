package project.vilsoncake.BookOnlineStore.service;

import org.springframework.ui.Model;
import project.vilsoncake.BookOnlineStore.entity.AddressEntity;
import project.vilsoncake.BookOnlineStore.entity.UserEntity;

import java.security.Principal;

public interface UserService {

    String addUser(UserEntity user, AddressEntity address, String confirmPassword, Model model);
    UserEntity getAuthenticatedUser(Principal principal, Model model);
}
