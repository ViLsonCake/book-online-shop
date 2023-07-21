package project.vilsoncake.BookOnlineStore.constant;

public class PatternConst {
    public static final String REGEX_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!_^&+=])(?=\\S+$).{8,16}$";
    public static final String REGEX_PHONE_NUMBER_PATTERN = "^\\w+?/\\w+?$";
    public static final String REGEX_ID_PATTERN = "^\\d+$";
    public static final String REGEX_EMAIL_PATTERN = "^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(?:aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$";
}
