package project.vilsoncake.BookOnlineStore.utils;

import org.springframework.stereotype.Component;
import project.vilsoncake.BookOnlineStore.entity.UserEntity;
import project.vilsoncake.BookOnlineStore.repository.UserRepository;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.*;
import static project.vilsoncake.BookOnlineStore.constant.PatternConst.REGEX_EMAIL_PATTERN;
import static project.vilsoncake.BookOnlineStore.constant.PatternConst.REGEX_PASSWORD_PATTERN;

@Component
public class UserUtils {

    private final UserRepository userRepository;

    public UserUtils(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, String> isValidUser(UserEntity user, String confirmPassword) {
        return Map.of(
                "firstNameError", isValidName(user.getFirstName()) ? "" : FIRST_NAME_SIZE_MESSAGE,
                "lastNameError", isValidName(user.getLastName()) ? "" : LAST_NAME_SIZE_MESSAGE,
                "emailError", isValidEmail(user.getEmail()) ? "" : EMAIL_INVALID_MESSAGE,
                "phoneNumberError", isValidPhoneNumber(user.getPhoneNumber()) ? "" : PHONE_NUMBER_SIZE_MESSAGE,
                "passwordError", isValidPassword(user.getPassword()) ? "" : PASSWORD_INVALID_MESSAGE,
                "passwordConfirmError", isValidConfirmPassword(user.getPassword(), confirmPassword) ? "" : PASSWORD_ERROR_MESSAGE,
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

    public boolean isValidName(String name) {
        return name.length() < 30 && name.length() > 2;
    }

    public boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(REGEX_EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(REGEX_PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public boolean isValidConfirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.length() >= 9 && phoneNumber.length() <= 15;
    }
}
