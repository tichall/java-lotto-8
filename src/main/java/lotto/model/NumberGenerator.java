package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.ErrorMessage;

public class NumberGenerator {
    public List<Integer> generateDistinctNumbers(int size, int min, int max) {
        validateSize(size, min, max);

        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(min, max);
            uniqueNumbers.add(randomNumber);
        }

        return new ArrayList<>(uniqueNumbers);
    }

    private static void validateSize(int size, int min, int max) {
        if (size > (max - min + 1)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE_FOR_RANGE.getValue());
        }
    }
}
