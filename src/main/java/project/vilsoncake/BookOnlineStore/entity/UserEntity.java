package project.vilsoncake.BookOnlineStore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import project.vilsoncake.BookOnlineStore.constant.MessageConst;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.*;
import static project.vilsoncake.BookOnlineStore.constant.PatternConst.REGEX_PASSWORD_PATTERN;

@Entity
@Table(name = "user_")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotEmpty(message = FIRST_NAME_EMPTY_MESSAGE)
    @Size(min = 2, max = 30, message = FIRST_NAME_SIZE_MESSAGE)
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty(message = LAST_NAME_EMPTY_MESSAGE)
    @Size(min = 2, max = 30, message = LAST_NAME_SIZE_MESSAGE)
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty(message = EMAIL_EMPTY_MESSAGE)
    @Email(message = EMAIL_INVALID_MESSAGE)
    @Column(name = "email")
    private String email;
    @NotEmpty(message = PASSWORD_EMPTY_MESSAGE)
    @Pattern(regexp = REGEX_PASSWORD_PATTERN, message = PASSWORD_INVALID_MESSAGE)
    @Column(name = "password")
    private String password;
    @NotEmpty(message = PHONE_NUMBER_EMPTY_MESSAGE)
    @Size(min = 9, max = 15, message = PHONE_NUMBER_SIZE_MESSAGE)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "active")
    private boolean active;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id", unique = true))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private AddressEntity address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<OrderEntity> orders;

    public UserEntity() {}

    public UserEntity(String firstName, String lastName, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }
}
