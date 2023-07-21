package project.vilsoncake.BookOnlineStore.utils;

import org.springframework.stereotype.Component;
import project.vilsoncake.BookOnlineStore.entity.AddressEntity;

import java.util.Map;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.*;

@Component
public class AddressUtils {

    public Map<String, String> validateAddress(AddressEntity address) {
        return Map.of(
                "countryError", isValidCountry(address.getCountry()) ? "" : COUNTRY_SIZE_MESSAGE,
                "cityError", isValidCity(address.getCity()) ? "" : CITY_SIZE_MESSAGE,
                "streetError", isValidStreet(address.getStreet()) ? "" : STREET_INVALID_MESSAGE,
                "postalCodeError", isValidPostalCode(address.getPostalCode()) ? "" : POSTAL_CODE_SIZE_MESSAGE
        );
    }

    public Map<String, String> addressToMap(AddressEntity address) {
        return Map.of(
                "country", address.getCountry(),
                "city", address.getCity(),
                "street", address.getStreet(),
                "postalCode", address.getPostalCode()
        );
    }

    public boolean isValidCountry(String country) {
        return country.length() > 3 && country.length() < 30;
    }

    public boolean isValidCity(String city) {
        return city.length() > 3 && city.length() < 30;
    }

    public boolean isValidStreet(String street) {
        return (street.length() > 5 && street.length() < 64) && (street.contains("/") || street.contains("\\"));
    }

    public boolean isValidPostalCode(String postalCode) {
        return postalCode.length() > 3 && postalCode.length() < 12;
    }
}
