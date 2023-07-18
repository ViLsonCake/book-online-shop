package project.vilsoncake.BookOnlineStore.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import project.vilsoncake.BookOnlineStore.entity.UserEntity;
import project.vilsoncake.BookOnlineStore.repository.UserRepository;
import project.vilsoncake.BookOnlineStore.service.AdminService;
import project.vilsoncake.BookOnlineStore.utils.ValidateUtils;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.USER_NOT_FOUND_MESSAGE;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String findUser(String userId, Model model) {
        UserEntity user = ValidateUtils.isNumeric(userId) ?
                userRepository.findById(Long.parseLong(userId)).get() : userRepository.findByEmail(userId);

        if (user == null) {
            model.addAttribute("userNotFoundError", USER_NOT_FOUND_MESSAGE);
            return "admin/user-data.html";
        }

        model.addAttribute("user", user);
        return "admin/user-data.html";
    }

    @Override
    public String changeUserActive(String userId) {
        UserEntity user = ValidateUtils.isNumeric(userId) ?
                userRepository.findById(Long.parseLong(userId)).get() : userRepository.findByEmail(userId);

        user.setActive(!user.isActive());
        userRepository.save(user);
        return "admin/user-data.html";
    }
}
