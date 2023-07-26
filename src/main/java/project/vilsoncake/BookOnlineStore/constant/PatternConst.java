package project.vilsoncake.BookOnlineStore.constant;

public class PatternConst {
    public static final String REGEX_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!_^&+=])(?=\\S+$).{8,16}$";
    public static final String REGEX_ID_PATTERN = "^\\d+$";
    public static final String REGEX_EMAIL_PATTERN = "^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(?:aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$";
    public static final String REGEX_NAME_PATTERN = "^[A-Z]{1}[a-z]+?$";
    public static final String REGEX_ONLY_LETTERS_PATTERN = "^[a-zA-Z]{3,}$";
}
