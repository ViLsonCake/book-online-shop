package project.vilsoncake.BookOnlineStore.constant;

import static project.vilsoncake.BookOnlineStore.constant.NameConst.*;

public class MessageConst {

    public static final String USER_EXISTS_MESSAGE = "User with this email already exists";
    public static final String PASSWORD_ERROR_MESSAGE = "Passwords don't match";
    public static final String USER_SAVED_MESSAGE = "User with email {} saved";
    public static final String USER_NOT_FOUND_MESSAGE = "User not found";
    public static final String FIRST_NAME_SIZE_MESSAGE = "First name should be between 2 and 30 characters";
    public static final String LAST_NAME_SIZE_MESSAGE = "Last name should be between 2 and 30 characters";
    public static final String EMAIL_INVALID_MESSAGE = "Email is not valid";
    public static final String PASSWORD_INVALID_MESSAGE = "The password must contain at least one number, an uppercase letter and a special character";
    public static final String PHONE_NUMBER_SIZE_MESSAGE = "Phone number should be between 9 and 15 characters";
    public static final String COUNTRY_SIZE_MESSAGE = "Country name should be between 3 and 64 characters";
    public static final String CITY_SIZE_MESSAGE = "City name should be between 3 and 64 characters";
    public static final String POSTAL_CODE_SIZE_MESSAGE = "Postal code should be between 3 and 15 characters";
    public static final String STREET_INVALID_MESSAGE = "Street must contain street number and house number separated by '/' or '\\'";
    public static final String ERROR_404_MESSAGE = "Maybe this page moved? Got deleted? Is hiding out in quarantine? Never existed in the first place?";
    public static final String ERROR_403_MESSAGE = "Not this time, access forbidden!";
    public static final String UNKNOWN_ERROR_MESSAGE = "Houston, we have a problem";
    public static final String BOOK_NOT_FOUND_MESSAGE = "Unable to find book in warehouse";
    public static final String BOOK_ALREADY_EXIST_MESSAGE = "This book already exist";
    public static final String BOOK_NAME_INVALID_MESSAGE = "Name should be between 3 and 30 characters";
    public static final String BOOK_AUTHOR_INVALID_MESSAGE = "The author field must contain the first and last name and start with a capital letter";
    public static final String BOOK_PUBLISHER_INVALID_MESSAGE = "Publisher should be between 3 and 30 characters";
    public static final String BOOK_ISSUE_YEAR_INVALID_MESSAGE = "Year of issue can't be empty and must be greater than 0";
    public static final String BOOK_PAGE_INVALID_MESSAGE = "Page can't be empty and must be greater than 0";
    public static final String LANGUAGE_INVALID_MESSAGE = "Language must not contain non letters symbol";
    public static final String BINDING_INVALID_MESSAGE = "Binding should be " + BINDINGS_LIST;
    public static final String DESCRIPTION_INVALID_MESSAGE = "Description should be no more than 50 words";
    public static final String ISBN_INVALID_MESSAGE = "Isbn must contain 10 or 13 digits";
    public static final String CATEGORY_INVALID_MESSAGE = "Category should be " + BOOK_CATEGORIES;
    public static final String START_COUNT_INVALID_MESSAGE = "Start count can't be empty and must be greater than 0";
    public static final String FILE_EXTENSION_INVALID_MESSAGE = "File extension should be " + FILE_EXTENSIONS;
}
