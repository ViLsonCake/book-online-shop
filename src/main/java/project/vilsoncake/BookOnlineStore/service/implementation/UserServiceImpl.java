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
import project.vilsoncake.BookOnlineStore.service.UserService;
import project.vilsoncake.BookOnlineStore.utils.AddressUtils;
import project.vilsoncake.BookOnlineStore.utils.UserUtils;

import java.security.Principal;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.USER_NOT_FOUND_MESSAGE;
import static project.vilsoncake.BookOnlineStore.constant.MessageConst.USER_SAVED_MESSAGE;
import static project.vilsoncake.BookOnlineStore.entity.Role.USER;
import static project.vilsoncake.BookOnlineStore.utils.ValidateUtils.hasErrors;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final AddressService addressService;
    private final UserUtils userUtils;
    private final AddressUtils addressUtils;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, AddressService addressService, UserUtils userUtils, AddressUtils addressUtils, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressService = addressService;
        this.userUtils = userUtils;
        this.addressUtils = addressUtils;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public String addUser(UserEntity user, AddressEntity address, String confirmPassword, Model model) {
        Map<String, String> validateUser = userUtils.validateUser(user, confirmPassword);
        Map<String, String> validateAddress = addressUtils.validateAddress(address);

        if (hasErrors(validateUser) || hasErrors(validateAddress)) {
            model.addAllAttributes(validateUser);
            model.addAllAttributes(validateAddress);
            model.addAllAttributes(userUtils.userToMap(user, confirmPassword));
            model.addAllAttributes(addressUtils.addressToMap(address));
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
