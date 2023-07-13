package project.vilsoncake.BookOnlineStore.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import project.vilsoncake.BookOnlineStore.entity.AddressEntity;
import project.vilsoncake.BookOnlineStore.entity.UserEntity;
import project.vilsoncake.BookOnlineStore.repository.AddressRepository;
import project.vilsoncake.BookOnlineStore.repository.UserRepository;
import project.vilsoncake.BookOnlineStore.service.UserService;

import java.security.Principal;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.USER_EXISTS_MESSAGE;
import static project.vilsoncake.BookOnlineStore.entity.Role.ROLE_USER;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String addUser(UserEntity user, AddressEntity address, String confirmPassword, Model model) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("userExists", USER_EXISTS_MESSAGE);
            return "registration.html";
        }

        // Add extra user params and save
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.getRoles().add(ROLE_USER);
        userRepository.save(user);
        log.info("User with email {} saved", user.getEmail());

        // Add address to user
        address.setUser(user);
        addressRepository.save(address);

        return "redirect:/";
    }

    @Override
    public UserEntity getAuthenticatedUser(Principal principal, Model model) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }
}
