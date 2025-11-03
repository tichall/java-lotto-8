package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.utils.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;

    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return Collections.unmodifiableList(sortedNumbers);
    }

    public LottoRank getLottoRank(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = matchCount(winningNumbers);
        boolean matchBonus = matchBonus(bonusNumber);

        return LottoRank.valueOf(matchCount, matchBonus);
    }

    public int matchCount(List<Integer> winningNumbers) {
        int count = 0;

        for (int number : this.numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    public boolean matchBonus(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }
}
