package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessage;

public class LottoMachine {
    public List<Lotto> issue(int money) {
        validateMoney(money);
        return issueMultiple(calculateQuantity(money));
    }

    private List<Lotto> issueMultiple(int quantity) {
        List<Lotto> issuedLottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            issuedLottos.add(issueSingle());
        }
        return issuedLottos;
    }

    private Lotto issueSingle() {
        return new Lotto(generateNumbers());
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LottoConstants.NUMBER_COUNT.getValue(); i++) {
            Integer number = Randoms.pickNumberInRange(
                    LottoConstants.MIN_NUMBER.getValue(),
                    LottoConstants.MAX_NUMBER.getValue());
            numbers.add(number);
        }
        return numbers;
    }

    private void validateMoney(int insertedMoney) {
        if (insertedMoney <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_MUST_BE_POSITIVE.getValue());
        }
    }

    private int calculateQuantity(int money) {
        if (money % LottoConstants.PRICE.getValue() == 0) {
            return money / LottoConstants.PRICE.getValue();
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_UNIT.getValue());
    }
}
