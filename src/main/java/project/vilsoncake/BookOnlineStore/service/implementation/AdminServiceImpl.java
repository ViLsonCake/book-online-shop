package project.vilsoncake.BookOnlineStore.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import project.vilsoncake.BookOnlineStore.entity.UserEntity;
import project.vilsoncake.BookOnlineStore.repository.UserRepository;
import project.vilsoncake.BookOnlineStore.service.AdminService;
import project.vilsoncake.BookOnlineStore.utils.ValidateUtils;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.USER_NOT_FOUND_MESSAGE;
import static project.vilsoncake.BookOnlineStore.entity.Role.MANAGER;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String findUser(String userId, Model model) {
        UserEntity user = ValidateUtils.isNumeric(userId) ?
                userRepository.findById(Long.parseLong(userId)).isPresent() ? userRepository.findById(Long.parseLong(userId)).get() : null
                : userRepository.findByEmail(userId);

        if (user == null) {
            model.addAttribute("userNotFoundError", USER_NOT_FOUND_MESSAGE);
            return "admin/user-data.html";
        }

        model.addAttribute("user", user);
        return "admin/user-data.html";
    }

    @Override
    public String changeUserRole(Long userId, Model model) {
        UserEntity user = userRepository.findById(userId).get();

        if (user.getRoles().contains(MANAGER)) {
            user.getRoles().remove(MANAGER);
        } else {
            user.getRoles().add(MANAGER);
            userRepository.save(user);
        }
        model.addAttribute("user", user);
        return "admin/user-data.html";
    }

    @Override
    public String changeUserActive(Long userId, Model model) {
        UserEntity user = userRepository.findById(userId).get();
        user.setActive(!user.isActive());
        userRepository.save(user);
        model.addAttribute("user", user);
        return "admin/user-data.html";
    }

    @Override
    public String deleteUser(Long userId, Model model) {
        if (!userRepository.existsById(userId)) return "admin/user-data.html";
        userRepository.deleteById(userId);
        return "redirect:/admin/user-data";
    }
}
