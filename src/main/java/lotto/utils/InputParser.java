package lotto.utils;

import java.util.Arrays;
import java.util.List;
import lotto.ErrorMessage;

public class InputParser {
    private static final String DELIMITER = ",";

    public static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(InputParser::parseNumber)
                .toList();
    }

    public static Integer parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PARSE_INTEGER_ERROR.getMessage());
        }
    }
}