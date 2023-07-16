package project.vilsoncake.BookOnlineStore.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import project.vilsoncake.BookOnlineStore.entity.AddressEntity;
import project.vilsoncake.BookOnlineStore.entity.Role;
import project.vilsoncake.BookOnlineStore.entity.UserEntity;
import project.vilsoncake.BookOnlineStore.repository.UserRepository;
import project.vilsoncake.BookOnlineStore.service.AddressService;
import project.vilsoncake.BookOnlineStore.service.AvatarService;
import project.vilsoncake.BookOnlineStore.service.UserService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.*;
import static project.vilsoncake.BookOnlineStore.entity.Role.USER;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final AddressService addressService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, AddressService addressService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressService = addressService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public String addUser(UserEntity user, AddressEntity address, String confirmPassword, Model model) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("userExists", USER_EXISTS_MESSAGE);
            return "registration.html";
        }

        if (!user.getPassword().equals(confirmPassword) || user.getPassword().isEmpty()) {
            model.addAttribute("passwordError", PASSWORD_ERROR_MESSAGE);
            return "registration.html";
        }

        // Add extra user params and save
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.getRoles().add(USER);
        userRepository.save(user);
        log.info(USER_SAVED_MESSAGE, user.getEmail());

        // Add address to user
        addressService.addUserAddress(address, user);

        return "redirect:/";
    }

    @Override
    public UserEntity getAuthenticatedUser(Principal principal, Model model) {
        return null;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(rolesToAuthorities(user.getRoles()))
                .build();
    }

    public Collection<GrantedAuthority> rolesToAuthorities(Set<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
    }
}
