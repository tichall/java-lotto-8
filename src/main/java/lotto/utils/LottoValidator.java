package lotto.utils;

import java.util.List;
import lotto.ErrorMessage;
import lotto.model.LottoConstants;

public class LottoValidator {
    public static void validateLottoNumbers(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDistinctNumber(numbers);
        for (Integer number : numbers) {
            validateNumberInRange(number);
        }
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateDistinctNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoConstants.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateNumberInRange(Integer number) {
        boolean isInRange = (number >= LottoConstants.MIN_NUMBER.getValue()
                && number <= LottoConstants.MAX_NUMBER.getValue());
        if (!isInRange) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_OUT_OF_RANGE.getMessage());
        }
    }
}