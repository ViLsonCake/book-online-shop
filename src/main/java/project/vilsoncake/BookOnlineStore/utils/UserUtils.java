package project.vilsoncake.BookOnlineStore.utils;

import org.springframework.stereotype.Component;
import project.vilsoncake.BookOnlineStore.entity.UserEntity;
import project.vilsoncake.BookOnlineStore.repository.UserRepository;

import java.util.Map;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.*;

@Component
public class UserUtils {

    private final UserRepository userRepository;

    public UserUtils(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, String> validateUser(UserEntity user, String confirmPassword) {
        return Map.of(
                "firstNameError", validateName(user.getFirstName()) ? "" : FIRST_NAME_SIZE_MESSAGE,
                "lastNameError", validateName(user.getLastName()) ? "" : LAST_NAME_SIZE_MESSAGE,
                "emailError", validateEmail(user.getEmail()) ? "" : EMAIL_INVALID_MESSAGE,
                "phoneNumberError", validatePhoneNumber(user.getPhoneNumber()) ? "" : PHONE_NUMBER_SIZE_MESSAGE,
                "passwordError", validatePassword(user.getPassword()) ? "" : PASSWORD_INVALID_MESSAGE,
                "passwordConfirmError", validateConfirmPassword(user.getPassword(), confirmPassword) ? "" : PASSWORD_ERROR_MESSAGE,
                "userExistError", userRepository.findByEmail(user.getEmail()) == null ? "" : USER_EXISTS_MESSAGE
        );
    }

    public Map<String, String> userToMap(UserEntity user, String confirmPassword) {
        return Map.of(
                "firstName", user.getFirstName(),
                "lastName", user.getLastName(),
                "email", user.getEmail(),
                "phoneNumber", user.getPhoneNumber(),
                "password", user.getPassword(),
                "confirmPassword", confirmPassword
        );
    }

    public boolean validateName(String name) {
        return name.length() < 30 && name.length() > 2;
    }

    public boolean validateEmail(String email) {
        return !email.isEmpty();
    }

    public boolean validatePassword(String password) {
        return password.length() >= 8 && password.length() <= 16;
    }

    public boolean validateConfirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.length() >= 9 && phoneNumber.length() <= 15;
    }
}
