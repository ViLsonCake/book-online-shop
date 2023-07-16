package project.vilsoncake.BookOnlineStore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.*;
import static project.vilsoncake.BookOnlineStore.constant.PatternConst.REGEX_PHONE_NUMBER_PATTERN;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    @NotEmpty(message = COUNTRY_EMPTY_MESSAGE)
    @Size(min = 2, max = 64, message = COUNTRY_SIZE_MESSAGE)
    @Column(name = "country")
    private String country;
    @NotEmpty(message = CITY_EMPTY_MESSAGE)
    @Size(min = 2, max = 64, message = CITY_SIZE_MESSAGE)
    @Column(name = "city")
    private String city;
    @NotEmpty(message = POSTAL_CODE_EMTPY_MESSAGE)
    @Size(min = 3, max = 15, message = POSTAL_CODE_SIZE_MESSAGE)
    @Column(name = "postal_code")
    private String postalCode;
    @NotEmpty(message = STREET_EMTPY_MESSAGE)
    @Pattern(regexp = REGEX_PHONE_NUMBER_PATTERN, message = STREET_INVALID_MESSAGE)
    @Column(name = "street")
    private String street;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public AddressEntity() {}

    public AddressEntity(String country, String city, String postalCode, String street) {
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
