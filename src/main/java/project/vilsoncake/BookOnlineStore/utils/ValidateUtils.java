package project.vilsoncake.BookOnlineStore.utils;

import java.util.List;
import java.util.Map;

public class ValidateUtils {

    public static boolean hasErrors(Map<String, String> validateResult) {
        List<String> mapValues = validateResult.values().stream().toList();

        for (String value : mapValues) {
            if (!value.isEmpty())
                return true;
        }

        return false;
    }
}
