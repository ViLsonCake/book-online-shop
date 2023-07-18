package project.vilsoncake.BookOnlineStore.utils;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static project.vilsoncake.BookOnlineStore.constant.PatternConst.REGEX_ID_PATTERN;

public class ValidateUtils {

    public static boolean hasErrors(Map<String, String> validateResult) {
        List<String> mapValues = validateResult.values().stream().toList();

        for (String value : mapValues) {
            if (!value.isEmpty())
                return true;
        }

        return false;
    }

    public static boolean isNumeric(String id) {
        Pattern pattern = Pattern.compile(REGEX_ID_PATTERN);
        Matcher matcher = pattern.matcher(id);

        return matcher.find();
    }
}
